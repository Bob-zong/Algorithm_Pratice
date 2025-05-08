import java.util.*;
import java.io.*;

public class Main {
    public static int n, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> s = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            s.add(Integer.parseInt(st.nextToken()));
        
        int cnt = 1;
        for(Integer num : s) {
            map.put(num, cnt++);
        }
        

        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int start = s.ceiling(x1);
            int end = s.floor(x2);
            int num = map.get(end) - map.get(start) + 1;
            sb.append(num).append("\n");
            
        }

        System.out.print(sb);
    }
}