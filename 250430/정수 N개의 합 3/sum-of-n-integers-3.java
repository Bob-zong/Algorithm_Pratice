import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[][] answer;
    public static int[][] prefixSum;

    public static int getSum(int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2]     - prefixSum[x1 - 1][y2] -
               prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        answer = new int[n+1][n+1];
        prefixSum = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 누적합 배열 만들기
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                prefixSum[i][j] = prefixSum[i-1][j] + 
                prefixSum[i][j-1]- 
                prefixSum[i-1][j-1] + 
                answer[i][j];
            }
        }

        int ans = 0;

        for(int i = 1; i <= n-k+1; i++){
            for(int j = 1; j <= n-k+1; j++){
                ans = Math.max(ans, getSum(i, j, i+k-1, j+k-1));
            }
        }
        
        System.out.print(ans);
            
    }
}