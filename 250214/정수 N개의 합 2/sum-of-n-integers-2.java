import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int n , k;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[n+1];
        int[] answer = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
            
        }

        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            prefixSum[i] = prefixSum[i-1] + answer[i];
        }

        for(int i = 1+k-1; i <= n; i++){
            max = Math.max(max, prefixSum[i] - prefixSum[i - k]);
        }

        System.out.print(max);

    }
}