import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static int[][] board;
    public static int[][] dp;

    public static void initialize() {
        dp[1][n] = board[1][n];

        for(int i = 2; i <= n; i++) {
            dp[i][n] = dp[i-1][n] + board[i][n];
            dp[1][n-i+1] = dp[1][n-i+2] + board[1][n-i+1];
        }

        for(int i = 2; i <= n; i++) {
            for(int j = n-1; j >= 1; j--) {
                dp[i][j] = Math.min(dp[i][j+1] + board[i][j], dp[i-1][j] + board[i][j]);
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        board = new int[n+1][n+1];
        dp = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initialize();

        System.out.print(dp[n][1]);


    }
}