import java.util.*;
import java.io.*;

public class Main {
    static final int OFFSET = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        int[][] answer = new int[201][201];

        for(int i = 0; i < n; i++){
            int x1, y1, x2, y2;
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            
            x1 += OFFSET;
            y1 += OFFSET; 
            x2 += OFFSET; 
            y2 += OFFSET;

            for(int x = x1; x < x2; x++){
                for(int y = y1; y < y2; y++){
                    answer[x][y] = 1;
                }
            }
        }
        int cnt = 0;

        for(int i = 0; i < 201; i++){
            for(int j = 0; j < 201; j++){
                if(answer[i][j] == 1){
                    cnt += 1;
                }
            }

        }
        System.out.print(cnt);
    }
}