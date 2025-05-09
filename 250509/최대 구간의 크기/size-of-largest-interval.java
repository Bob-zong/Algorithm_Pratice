import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int x, v, index;

    public Point(int x, int v, int index) {
        this.x = x;
        this.v = v;
        this.index = index;
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
        ArrayList<Point> points = new ArrayList<>();
        HashSet<Integer> s = new HashSet<>();


        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            points.add(new Point(x1, +1, i));
            points.add(new Point(x2, -1, i));
        }
        
        Collections.sort(points);

        int ans = 0;

        int start = points.get(0).x;
        int end = 0;

        for(int i = 0; i < 2 * n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;
            int index = points.get(i).index;
            
            if(v == 1) {
                
                if(s.size() == 0){
                    start = x;
                }

                s.add(index);

                
            }
            else{
                s.remove(index);
                if(s.size() == 0){
                    end = x;
                    int len = end - start;
                    ans = Math.max(ans, len);
                }
                    
            }
        }

        System.out.print(ans);

    }
}