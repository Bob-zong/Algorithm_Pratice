import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int x, v, index, y;

    public Point(int x, int v, int index, int y) {
        this.x = x;
        this.v = v;
        this.index = index;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;        // x 기준 오름차순 정렬 
    }
}

class Element implements Comparable<Element> {
    int y, index;

    public Element(int y, int index) {
        this.y = y;
        this.index = index;
    }

    @Override
    public int compareTo(Element e) {
        return this.y - e.y;        // y 기준 오름차순 정렬 
    }
}
// x값이 제일 작은 선분은 무조건 보이니까 y 값의 상관없이 추가하면 됨
// 2번째부터는 음.. Y값을 TreeSet에 넣어놓고 가장 Y값이 나보다 낮은 애들에 X값의 왼쪽 X의 최대값과 
// 오른쪽 시작점 오른쪽 X의 최솟값을 찾아서 내 X 시작과 끝 사이에 걸치지 않으면 추가해.


public class Main {
    public static final int MAX_N = 50000;
    // 보이는 색깔의 경우 true로 표기합니다.
    public static boolean[] visible = new boolean[MAX_N];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Point> points = new ArrayList<>();
        TreeSet<Element> segs = new TreeSet<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            points.add(new Point(x1, +1, i, y)); // 시작점
            points.add(new Point(x2, -1, i, y)); // 끝점
        }

        Collections.sort(points);

        for(int i = 0; i < 2 * n; i++) {
            int v = points.get(i).v;
            int index = points.get(i).index;
            int y = points.get(i).y;

            if(v == 1) {
                segs.add(new Element(y, index));
            }
            else{
                segs.remove(new Element(y, index));
            }

            if(segs.isEmpty())
                continue;
            
            // 현재 눈에 보이는 선분을 찾아
            // 해당 index에 true값을 적어줍니다.
            int targetIndex = segs.first().index;
            visible[targetIndex] = true;


        }

        int ans = 0;
        for(int i = 0; i < n; i++)
            if(visible[i])
                ans++;
        
        System.out.print(ans);
    }
}