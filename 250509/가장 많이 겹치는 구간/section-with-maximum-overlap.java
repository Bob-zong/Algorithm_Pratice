import java.util.*;
import java.io.*;

class Segment {
    int x1, x2;
    
    public Segment(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}

class Point implements Comparable<Point> {
    int x, v;

    public Point(int x, int v){
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Point> p = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int x1, x2;
            
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());

            p.add(new Point(x1, +1));
            p.add(new Point(x2, -1));
        }

        Collections.sort(p);

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < 2*n; i++){
            int x = p.get(i).x;
            int v = p.get(i).v;

            sum += v;

            max = Math.max(max,sum);
        }

        System.out.print(max);
    }
}