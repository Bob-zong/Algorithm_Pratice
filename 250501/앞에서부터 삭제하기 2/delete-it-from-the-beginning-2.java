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

        for(int k = 1; k <= n-2; k++){
            int sum = 0;
            pq = new PriorityQueue<>();
            for(int i = k+1; i <= n; i++){
                int val = answer[i];
                sum += val;
                pq.add(val);
            }
            sum -= pq.poll();
            maxAvg = Math.max(maxAvg, (float)(sum / pq.size()));
        }
        
        System.out.printf("%.2f", maxAvg);
    }
}