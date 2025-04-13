import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] xArr;
    public static int[] yArr;
    // x y 축과 평행한 선분이 존재하려면 점 중에 x 좌표가 같은 점 2개, y좌표 같은 좌표가 존재
    public static int getArea(int idx1, int idx2, int idx3) {
        int x1, x2, x3;
        int y1, y2, y3;

        int width = 0;
        int height = 0;
        
        x1 = xArr[idx1];
        y1 = yArr[idx1];

        x2 = xArr[idx2];
        y2 = yArr[idx2];
        
        x3 = xArr[idx3];
        y3 = yArr[idx3];

        if(x1 == x2){
            height = Math.abs(y2-y1);
            if(y1 == y3){
                width = Math.abs(x3-x1);
            }
            else if(y2 == y3){
                width = Math.abs(x3-x2);
            }
        }
        else if(x1 == x3){
            height = Math.abs(y3-y1);
            if(y1 == y2){
                width = Math.abs(x2-x1);
            }
            else if(y3 == y2){
                width = Math.abs(x3-x2);
            }
        }
        else if(x2 == x3){
            height = Math.abs(y3-y2);
            if(y1 == y2){
                width = Math.abs(x2-x1);
            }
            else if(y1 == y3){
                width = Math.abs(x3-x1);
            }
        }

        return width * height;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int maxArea = 0;

        n = Integer.parseInt(br.readLine());
        xArr = new int[n];
        yArr = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            xArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    int area = getArea(i, j, k);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        System.out.print(maxArea);
        
    }
}