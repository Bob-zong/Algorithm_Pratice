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

        // NLogN 만큼 시간 복잡도 -> 안됨
        int maxLen = 0;
    
        st = new StringTokenizer(br.readLine());
        int[] removed = new int[m];
        s.add(0);
        s.add(n);

        for(int i = 0; i < m; i++) {
            removed[i] = Integer.parseInt(st.nextToken());
        }

        
        for(int i = 0; i < m; i++) {
            s.add(removed[i]);
            
            int diff1 = removed[i] - s.lower(removed[i]);
            int diff2 = s.higher(removed[i]) - removed[i];
            maxLen = Math.max(diff1, diff2);
            sb.append(maxLen).append("\n");
        }
        
    
        System.out.print(sb);
    }
}