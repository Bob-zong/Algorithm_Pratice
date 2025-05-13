import java.util.*;
import java.io.*;

public class Main {
    public static final int mod = 7;
    public static int[] maxIdx = new int[mod];
    public static int[] minIdx = new int[mod];
    public static final int INT_MIN = -(int)(1e9);
    public static final int INT_MAX = (int)(1e9);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] answer = new int[n+1];
        int[] prefixSum = new int[n+1];

        // 3 8 9 15 17 17 20
        // 3 5 1 6  2  0  3

        for(int i = 1; i <= n; i++) {
            answer[i] = (Integer.parseInt(br.readLine()) % 7) ;
        }

        prefixSum[0] = 0;

        for(int i = 0; i < mod; i++){
            maxIdx[i] = INT_MIN;
            minIdx[i] = INT_MAX;
        }
        for(int i = 1; i <= n; i++) {
            prefixSum[i] = (prefixSum[i-1] + answer[i]) % 7;
            maxIdx[prefixSum[i]] = Math.max(maxIdx[prefixSum[i]], i);
            minIdx[prefixSum[i]] = Math.min(minIdx[prefixSum[i]], i);

        }
        
        int ans = 0;
        for(int i = 0; i < mod; i++) {
            ans = Math.max(ans, maxIdx[i] - minIdx[i]);
        }
        // O(N)처리 NlogN 까지도 괜춘
        System.out.print(ans);

        



    }
}
