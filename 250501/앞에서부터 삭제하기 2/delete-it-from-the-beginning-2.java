import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // k -> 1 ~ n-2

        // 배열에 값으 다 넣어. O(n)
        // 1 ~ k까지 배열을 순회하면서 q에 넣고 O(k)
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] answer = new int[n+1];

        for(int i = 1; i <= n; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        float maxAvg = 0;
        int sum = answer[n];
        pq.add(answer[n]);

        for(int k = n - 1; k >= 1; k--) {
            pq.add(answer[k]);
            sum += answer[k];

            int min = pq.peek();
            maxAvg = Math.max(maxAvg, ((float)(sum - min) / (n - k)));
            
        }
        
        System.out.printf("%.2f", maxAvg);
    }
}