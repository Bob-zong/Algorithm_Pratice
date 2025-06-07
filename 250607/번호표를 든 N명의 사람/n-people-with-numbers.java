import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_T = 1000000;
    public static final int MAX_N = 10000;

    public static int n, t, k;
    public static int[] time;

    public static boolean isPossible(int mid) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for(int i = 0; i < mid; i++)
            pq.add(time[i]);

        for(int i = mid; i < n; i++){
            int currTime = pq.poll();

            pq.add(currTime + time[i]);
        }


        int endTime = 0;
        while(!pq.isEmpty()) {
            endTime = Math.max(endTime, pq.poll());
        }

        return endTime <= t;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = 0;

        time = new int[n];

        for(int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right = n;
        int ans = n;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
            else {
                left = mid + 1;
            }
        }

        System.out.print(ans);

    }
}
