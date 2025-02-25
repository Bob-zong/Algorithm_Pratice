import java.util.*;
import java.io.*;

public class Main {
    static final int MIN_VALUE = Integer.MIN_VALUE;
    public static int n;
    public static int[] answer;
    public static int[] dp;

    public static void initialize() {
        for(int i = 1; i <= n; i++){
            dp[i] = MIN_VALUE;
        }
        dp[1] = answer[1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        answer = new int[n+1];
        dp = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }
        initialize();
        
        for(int i = 2; i <= n; i++){
            // System.out.println(dp[i]);
            dp[i] = Math.max(answer[i], dp[i-1] + answer[i]);
            
        }


        int maxNum = MIN_VALUE;

        for(int i = 1; i <= n; i++){
            maxNum = Math.max(maxNum, dp[i]);
        }

        // for(int i : dp){
        //     System.out.println(i);
        // }
        System.out.print(maxNum);

    }
}