import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, K;
    public static char[][] answer;
    public static int[][] prefixSumA;
    public static int[][] prefixSumB;
    public static int[][] prefixSumC;

    // public static int getSum(int x1, int y1, int x2, int y2) {
        
    // }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        prefixSumA = new int[N+1][M+1];
        prefixSumB = new int[N+1][M+1];
        prefixSumC = new int[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++){
                char ch = str.charAt(j-1);
                int v1 = 0, v2 = 0, v3 = 0;

                if(ch == 'a'){
                    v1 = 1;
                }
                else if(ch == 'b'){
                    v2 = 1;
                }
                else if(ch == 'c'){
                    v3 = 1;
                }

                prefixSumA[i][j] = prefixSumA[i-1][j] + prefixSumA[i][j-1] - prefixSumA[i-1][j-1] + v1;
                prefixSumB[i][j] = prefixSumB[i-1][j] + prefixSumB[i][j-1] - prefixSumB[i-1][j-1] + v2;
                prefixSumC[i][j] = prefixSumC[i-1][j] + prefixSumC[i][j-1] - prefixSumC[i-1][j-1] + v3;
            }
        }

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            
            int a = prefixSumA[r2][c2] - prefixSumA[r2][c1-1] - prefixSumA[r1-1][c2] + prefixSumA[r1-1][c1-1];
            int b = prefixSumB[r2][c2] - prefixSumB[r2][c1-1] - prefixSumB[r1-1][c2] + prefixSumB[r1-1][c1-1];
            int c = prefixSumC[r2][c2] - prefixSumC[r2][c1-1] - prefixSumC[r1-1][c2] + prefixSumC[r1-1][c1-1];

        
            sb.append(String.format("%d %d %d\n", a, b, c));
        
        }
        System.out.print(sb);
        // 10 ^ 5 * 10 ^ 3 * 10 ^ 3 -> 10^11 시간초과 
        // O(K) * O(1) * 


    }
}
