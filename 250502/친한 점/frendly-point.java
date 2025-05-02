import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair> {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if(this.x != p.x)
            return this.x - p.x;
        else
            return this.y - p.y;
    } 
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeSet<Pair> s = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            s.add(new Pair(x, y));
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Pair curr = new Pair(x, y);
            if(s.ceiling(curr) != null){
                Pair cu = s.ceiling(curr);
                sb.append(cu.x + " " + cu.y).append("\n");
            }
                
            else 
                sb.append("-1 -1").append("\n");
        }

        System.out.print(sb);
    }
}