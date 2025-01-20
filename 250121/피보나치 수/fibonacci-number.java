import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int dp[];
    public static int memo[];

    public static int Fibbo(int n){
        if(memo[n] != -1)
            return memo[n];
        if(n <= 2)
            memo[n] = 1;
        else{
            memo[n] = Fibbo(n-1) + Fibbo(n-2);
        }
        return memo[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[46];
        int n = Integer.parseInt(br.readLine());
        // memo = new int[46];
        // Arrays.fill(memo, -1);
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        // int ans = Fibbo(n);
        System.out.print(dp[n]);

        
    }
}