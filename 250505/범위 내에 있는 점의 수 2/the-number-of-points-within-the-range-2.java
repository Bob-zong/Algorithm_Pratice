import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NUM = 1000000;
    public static int n, q;
    public static int[] answer;
    public static int[] prefixSum;

    public static int getSum(int s, int e) {
        return ( prefixSum[e] - prefixSum[s] + answer[s] );
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        answer = new int[MAX_NUM+1];
        prefixSum = new int[MAX_NUM+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            answer[num] = 1;
        }

        for(int i = 1; i <= MAX_NUM; i++) {
            prefixSum[i] = prefixSum[i-1] + answer[i];
        }

        for(int i = 1; i <= q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            int cnt = getSum(s, e);
            sb.append(cnt).append("\n");

        }

        System.out.print(sb);
    }
}