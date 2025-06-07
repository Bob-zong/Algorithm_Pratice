import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int s, e;

    public Point(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Point p) {
        return this.s - p.s;
    }

}

public class Main {
    public static final int MAX_NUM = (int)1e9;
    public static int n;
    public static Point[] segments;

    public static boolean isPossible(int dist) {
        int currX = segments[0].s;
        
        for(int i = 1; i < n; i++) {
            int s = segments[i].s;
            int e = segments[i].e;

            if(e < currX + dist)
                return false;
            
            currX = Math.max(currX + dist, s);
        }

        return true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        segments = new Point[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x, y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            segments[i] = new Point(x, y);
        }

        Arrays.sort(segments, 0, n);


        int left = 0;
        int right = MAX_NUM;

        int ans = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
            else {
                right = mid - 1;
            }
        }
        

        System.out.print(ans);
    }
}