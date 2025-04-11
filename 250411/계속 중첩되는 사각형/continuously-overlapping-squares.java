import java.util.*;
import java.io.*;

public class Main {
    public static final int OFFSET = 100;

    public static int n;
    public static int[][] answer;

    public static int x1, y1, x2, y2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        answer = new int[201][201];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x1 = OFFSET + Integer.parseInt(st.nextToken());
            y1 = OFFSET + Integer.parseInt(st.nextToken());
            x2 = OFFSET + Integer.parseInt(st.nextToken());
            y2 = OFFSET + Integer.parseInt(st.nextToken());

            for(int x = x1; x < x2; x++){
                for(int y = y1; y < y2; y++){
                    if(i % 2 == 0){
                        answer[x][y] = 1;
                    }else{
                        answer[x][y] = 2;
                    }
                }
            }
        }
        
        int area = 0;

        for(int i = 1; i <= 200; i++){
            for(int j = 1; j <= 200; j++){
                if(answer[i][j] == 2)
                    area += 1;
            }
        }

        // for(int x = 100; x <= 110; x++){
        //         for(int y = 100; y <= 110; y++){
        //             System.out.print(answer[x][y] + " ");
        //         }
        //         System.out.println();
        //     }

        System.out.print(area);
        

    }
}