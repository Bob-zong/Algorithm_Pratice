import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_M = 100000;

    public static int n , m;
    public static int[] time = new int[MAX_M];

    public static boolean isPossible(long mid) {
        long cnt = 0;

        for(int i = 0; i < m; i++) {
            cnt += mid / time[i];
        }

        return cnt >= n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        
        for(int i = 0; i < m; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(time, 0, m);

        long ans = Long.MAX_VALUE;

        long left = 0;
        long right = (long)time[m-1] * n;
        
        while(left <= right) {
            long mid = (left + right) / 2;

            if(isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
            else
                left = mid + 1;
        }

        System.out.print(ans);
        

    }
}