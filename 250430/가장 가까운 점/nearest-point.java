import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    // @Override
    // public int compareTo(Pair p) {
    //     int thisSum = this.x + this.y;
    //     int otherSum = p.x + p.y;

    //     if (thisSum != otherSum)
    //         return thisSum - otherSum;
    //     else
    //         return this.x - p.x;
    // }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                int sumA = a.x + a.y;
                int sumB = b.x + b.y;
                if (sumA != sumB)
                    return sumA - sumB;
                else
                    return a.x - b.x;
            }
        );

        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.add(new Pair(x, y));
        }

        for(int i = 0; i < m; i++){
            Pair curr = pq.poll();
            // System.out.print(curr.x);
            pq.add(new Pair(curr.x+2, curr.y+2));
        }

        Pair curr = pq.poll();
        System.out.print(curr.x + " " + curr.y);
    }
}