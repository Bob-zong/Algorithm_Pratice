import java.util.*;
import java.io.*;

public class Main {
    public static int n , m;
    public static int maxScale;
    
    public static int[][] answer;
    
    public static void simulation() {
        maxScale = -1;

        for(int x1 = 0; x1 < n; x1 ++){
            for(int y1 = 0; y1 < m; y1++){

                for(int x2 = x1; x2 < n; x2++){
                    for(int y2 = y1; y2 < m; y2++){
                        maxScale = Math.max(maxScale, getScale(x1, y1, x2, y2));
                    }
                }
            }
        }

    }

    public static int getScale(int x1, int y1, int x2, int y2){
        int Scale = 0;

        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                if(answer[i][j] <= 0)
                    return -1;
                else
                    Scale += 1;
            }
        }
        return Scale;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        simulation();

        System.out.print(maxScale);
    }
}