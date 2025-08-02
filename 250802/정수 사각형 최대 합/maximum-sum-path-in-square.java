import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] dp, board;

    public static int ans;

    public static void initialize() {
        dp[1][1] = board[1][1];

        for(int i = 2; i <= n; i++) {
            dp[1][i] = dp[1][i-1] + board[1][i];
            dp[i][1] = dp[i-1][1] + board[i][1];
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 2; j <= n; j++) {
                dp[i][j] = Math.max(dp[i-1][j] + board[i][j], dp[i][j-1] + board[i][j]);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        board = new int[n+1][n+1];
        dp = new int[n+1][n+1];

        ans = 0;

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initialize();

        System.out.print(dp[n][n]);

    }
}