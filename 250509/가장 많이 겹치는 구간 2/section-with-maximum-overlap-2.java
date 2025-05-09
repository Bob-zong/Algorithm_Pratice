import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int x, v;
    
    public Point(int x, int v) {
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(Point p){
        return this.x - p.x;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Point> points = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int x1, x2;

            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());

            points.add(new Point(x1, +1));
            points.add(new Point(x2, -1));
        }

        int ans = 0;

        Collections.sort(points);

        int sum = 0;
        for(int i = 0; i < 2 * n; i++) {
            int v = points.get(i).v;

            sum += v;

            ans = Math.max(ans, sum);
        }

        System.out.print(ans);
    }
}