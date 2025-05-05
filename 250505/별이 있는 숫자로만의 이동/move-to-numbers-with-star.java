import java.util.*;
import java.io.*;

public class Main {
    public static int N, K;
    public static int[][] answer;
    public static int[][] prefixSum;
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        answer = new int[N+1][N+1];
        prefixSum = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
                prefixSum[i][j] = prefixSum[i][j-1] + answer[i][j];
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                // r행일 때 j-c ~ j+c열 까지의 부분합을 더한다.
                // c = k - abs(i - r);
                int sum_all = 0;
                for(int r = i - K; r <= i + K; r++) {
                    int c = K - Math.abs(i-r);

                    if(1 <= r && r <= N)
                        sum_all += prefixSum[r][Math.min(j+c, N)] - prefixSum[r][Math.max(j - c - 1, 0)];
                }
                ans = Math.max(ans, sum_all);
            }
        }

        System.out.print(ans);
    }
}