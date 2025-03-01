import java.util.*;
import java.io.*;

public class Main {
    public static final int OFFSET = 100;
    public static final int MAX_N = 100;
    public static int[] x1 = new int[MAX_N];
    public static int[] y1 = new int[MAX_N];
    public static int[] x2 = new int[MAX_N];
    public static int[] y2 = new int[MAX_N];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] answer = new int[201][201];
  

        for(int k = 0; k < n; k++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) + OFFSET;
            int y = Integer.parseInt(st.nextToken()) + OFFSET;

            x1[k] = x;
            x2[k] = x + 8;
            y1[k] = y;
            y2[k] = y + 8;
        }

        for(int i = 0; i < n; i++){
            for(int x = x1[i]; x < x2[i]; x++)
                for(int y = y1[i]; y < y2[i]; y++)
                    answer[x][y] = 1;
        }
        
        
        int cnt = 0;

        for(int i = 0; i < 201; i++){
            for(int j = 0; j < 201; j++){
                if(answer[i][j] == 1)
                    cnt += 1;
            }
        }
        System.out.print(cnt);
    }
}