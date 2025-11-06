import java.util.*;
import java.io.*;

public class Main {
    public static final int UNUSED = -1;
    public static final int MAX_NUM = 1000;

    public static int n;

    // public static int[] memo = new int[MAX_NUM + 1];
    public static long[] dp = new long[MAX_NUM + 1];

    // public static void initializeMemo() {
    //     for(int i = 0; i <= MAX_NUM; i++) {
    //         memo[i] = UNUSED;
    //     }
    // }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        }
        System.out.print(dp[n]);
    }
}