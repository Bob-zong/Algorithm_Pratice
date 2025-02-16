import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] answer = new int[n+1];
        int[] prefixSum = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            prefixSum[i] = prefixSum[i-1] + answer[i];
        }
        
        int cnt = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(prefixSum[i] - prefixSum[j] == k)
                    cnt += 1;
            }
        }

        System.out.print(cnt);
        
    }
}