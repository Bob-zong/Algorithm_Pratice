import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NUM = 1000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[MAX_NUM + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;

        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] * 2 + dp[i-2] * 4) % 1000000007;
        }
        System.out.print(dp[n]);
    }
}