import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static final int MAX_NUM = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // n -> 2 * a + 3 * b 가 될 때 만족 dp[]
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[MAX_NUM+1];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i <= n; i++){
            dp[i] = (dp[i-2] + dp[i-3]) % 10007;
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        
    }
}