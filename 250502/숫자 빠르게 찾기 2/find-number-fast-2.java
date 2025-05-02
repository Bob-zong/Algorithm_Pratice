import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        TreeSet<Integer> s = new TreeSet<>();

        for(int i = 0; i < n; i++){
            s.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0 ; i < m; i++){
            int num = Integer.parseInt(br.readLine());

            if(s.ceiling(num) != null) {
                sb.append(s.ceiling(num)).append("\n");
            }else{
                sb.append(-1).append("\n");
            }

        }
        
        System.out.print(sb);
    }
}