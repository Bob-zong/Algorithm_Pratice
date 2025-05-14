import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_POS = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, k;

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] candyPos = new int[MAX_POS+1];
        long[] prefixSum = new long[MAX_POS+1];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int candyCnt = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            candyPos[pos] += candyCnt;
        }

        prefixSum[0] = candyPos[0];
        for(int i = 1; i <= MAX_POS; i++){
            prefixSum[i] = prefixSum[i-1] + candyPos[i];
        }

        long ans = 0;
        if(k >= MAX_POS){
            ans = prefixSum[MAX_POS];
        }
            
        else{
            for(int i = k; i <= MAX_POS - k; i++) {
                ans = Math.max(ans, (prefixSum[i+k] - prefixSum[i-k] + candyPos[i-k]));
            }  
        }
        
        // 0 1 2 3 4 5 6 7;

        System.out.print(ans);

    }
}