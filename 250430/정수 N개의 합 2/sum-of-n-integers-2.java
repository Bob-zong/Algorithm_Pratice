import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] prefixSum = new int[n+1];
        int[] answer = new int[n+1];

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + answer[i];
        }

        int ans = 0;
        
        for(int i = k; i <= n; i++){
            ans = Math.max(ans, prefixSum[i] - prefixSum[i-k]);
        }

        System.out.print(ans);
    }
}