import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    long s, e;

    public Point(long s, long e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Point p) {
        if(s > p.s) return 1;
        if(s < p.s) return -1;

        if(e > p.e) return 1;
        
        return -1;

    }

}
public class Main {
    public static final long MAX_NUM = (long)1e18;
    public static final int MAX_M = 100000;

    public static int n, m;
    public static Point[] segments = new Point[MAX_M];

    public static boolean isPossible(long dist) {
        // 놓을 수 있는 점 계산
        int cnt = 0 ;
        long lastX = -MAX_NUM;

        for(int i = 0; i < m; i++) {
            long s = segments[i].s;
            long e = segments[i].e;

            while(lastX + dist <= e) {
                cnt++;
                lastX = Math.max(s, lastX + dist);

                if(cnt >= n)
                    break;
            }
        }


        return cnt >= n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            segments[i] = new Point(start, end);
        }

        Arrays.sort(segments, 0, m);

        long left = 1;
        long right = MAX_NUM;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if(isPossible(mid)) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
            else
                right = mid - 1;
            
        }
        

        System.out.print(ans);
        
    }
}