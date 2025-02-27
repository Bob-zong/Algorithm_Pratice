import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int n, k;
       
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] block = new int[n+1];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for(int j = start; j <= end; j++){
                block[j] += 1;
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            max = Math.max(max, block[i]);
        }

        System.out.print(max);
    }
}