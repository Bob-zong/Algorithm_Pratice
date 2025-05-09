import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int x, v, index;

    public Point(int x, int v, int index){
        this.x = x;
        this.v = v;
        this.index = index;
    }

    @Override
    public int compareTo(Point p) { // x 오름차순
        return this.x - p.x;
    }
};

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

            points.add(new Point(x1, +1, i));
            points.add(new Point(x2, -1, i));
        }

        // 정렬을 진행합니다.
        // ArrayList에 대한 정렬에는 Collections를 이용합니다.
        Collections.sort(points);

        HashSet<Integer> s = new HashSet<>();

        int ans = 0;
        
        for(int i = 0; i < 2 * n; i++){
            int x = points.get(i).x;
            int v = points.get(i).v;
            int idx = points.get(i).index;

            if(v == 1) {

                if(s.size() == 0)
                    ans += 1;
                

                s.add(idx);
            } 

            else {
                s.remove(idx);
            }


        }

        System.out.println(ans);
    }
}