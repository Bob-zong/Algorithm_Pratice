import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0;i < n; i++){
            pq.add(-1 * Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < m; i++){
            int num = 1 + pq.poll();
            pq.add(num);
        }

        System.out.print(-1 * pq.peek());
    }
}