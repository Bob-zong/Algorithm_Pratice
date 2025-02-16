import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[][] answer;
    public static int[][] prefixSum;

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

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                prefixSum[i][j] = prefixSum[i-1][j] + 
                prefixSum[i][j-1]- 
                prefixSum[i-1][j-1] + 
                answer[i][j];
            }
        }

        int maxSum = 0;

        for(int i = k; i <= n; i++){
            for(int j = k; j <= n; j++){
                maxSum = Math.max(maxSum, prefixSum[i][j] - 
                prefixSum[i-k][j] - prefixSum[i][j-k] + 
                prefixSum[i-k][j-k]);
                //prefixSum[3][3] - prefixSum[2][3] - prefixSum[3][2] + prefixSum[1][1];
            }
        }
        
        System.out.print(maxSum);

            
    }
}