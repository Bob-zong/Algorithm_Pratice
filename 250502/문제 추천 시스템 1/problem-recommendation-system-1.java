import java.util.*;
import java.io.*;

class Pair implements Comparable <Pair> {
    int num, level;

    public Pair(int num, int level){
        this.num = num;
        this.level = level;
    }

    @Override
    public int compareTo(Pair p) {
        if(this.level != p.level)
            return this.level - p.level;
        else
            return this.num - p.num;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeSet<Pair> s = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            Pair p = new Pair(num, level);
            s.add(p);
        }

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("rc")){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    Pair p = s.last();
                    sb.append(p.num).append("\n");
                }
                else{
                    Pair p = s.first();
                    sb.append(p.num).append("\n");
                }  
            }
            else if(cmd.equals("ad")){
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                Pair p = new Pair(num , level);
                s.add(p);
            }
            else{
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                Pair p = new Pair(num , level);
                s.remove(p);
            }
        }
        System.out.print(sb);
    }
}