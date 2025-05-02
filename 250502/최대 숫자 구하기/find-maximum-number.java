import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> s = new TreeSet<>();


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= m; i++)
            s.add(i);

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            
            s.remove(num);
            sb.append(s.last()).append("\n");
            
        }

        System.out.print(sb);
    }
}