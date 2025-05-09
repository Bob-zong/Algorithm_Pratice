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
    public static final int MAX_N = 100000;
    public static int[] assignedNums = new int[MAX_N];
    public static PriorityQueue<Integer> computers = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Point> points = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            

            points.add(new Point(x1, +1, i));
            points.add(new Point(x2, -1, i));
            computers.add(i+1);
        }

        Collections.sort(points);

        for(int i = 0; i < 2 * n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;
            int index = points.get(i).index;

            if(v == 1) {
               int computerNum = computers.poll();

                // 해당 사용자에게 컴퓨터 번호를 매칭해줍니다.
                assignedNums[index] = computerNum;

            }
            else{
              // 해당 사람의 컴퓨터를 다시
                // 사용가능 상태로 만들어줍니다.
                int computerNum = assignedNums[index];
                computers.add(computerNum);
            }

        }

        for(int i = 0; i < n; i++)
            System.out.print(assignedNums[i] + " ");
        
    }
}