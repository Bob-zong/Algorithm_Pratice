import java.util.*;
import java.io.*;

public class Main {
    public static int n, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> s = new TreeSet<>();


        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            s.add(num);
        }

        int cnt = 1;
        for(Integer num : s)
            map.put(num, cnt++);
        
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int ans = map.get(end) - map.get(start) + 1;
            sb.append(ans).append("\n");
        }

        System.out.print(sb);

    }
}