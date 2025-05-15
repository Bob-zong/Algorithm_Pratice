import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(answer);

        int[] dp = new int[n]; // dp[i]: i를 시작점으로 하는 최대 구간 길이
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && answer[j] - answer[i] <= k) {
                j++;
            }
            dp[i] = j - i;
        }

        // R[i] = i부터 n까지 중 최대 dp값 (suffix max)
        int[] R = new int[n + 1];
        R[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            R[i] = Math.max(R[i + 1], dp[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i] + R[i + dp[i]]);
        }

        System.out.println(ans);
    }
}
