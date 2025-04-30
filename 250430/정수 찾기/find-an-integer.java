import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> hs = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++)
            hs.add(Integer.parseInt(st.nextToken()));

        int n2 = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n2; i++){
            int num = Integer.parseInt(st.nextToken());
            if(hs.contains(num))
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }

        System.out.print(sb);
    }
}