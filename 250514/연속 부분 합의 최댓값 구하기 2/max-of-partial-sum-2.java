import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        int[] answer = new int[n+1];
        int[] prefixSum = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + answer[i];
        }

        int j = 1;
        // int ans = Integer.MIN_VALUE;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            sum = Math.max(sum, 0) + answer[i];
            max = Math.max(max, sum);
        }

        System.out.print(max);
    }
}