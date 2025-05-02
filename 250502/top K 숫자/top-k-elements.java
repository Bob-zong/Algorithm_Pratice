import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> s = new TreeSet<>((a,b) -> b - a);
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }
        int cnt = 0;
        for(int i : s){
            if(cnt == k)
                break;
            cnt++;
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}