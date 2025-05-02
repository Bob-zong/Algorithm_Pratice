import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair> {
    int x, y;

    public Pair(int x, int y){
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Pair> s = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            s.add(new Pair(x, y));
        }

        for(int i = 0; i < m; i++){
            int k = Integer.parseInt(br.readLine());

            Pair p = new Pair(k, 0);
            
            if(s.ceiling(p) != null){
                Pair removeDot = s.ceiling(p);
                s.remove(removeDot);
                sb.append(removeDot.x + " " + removeDot.y).append("\n");    
            }else{
                sb.append("-1 -1").append("\n");
            }
            
        }
        System.out.print(sb);
    }
}