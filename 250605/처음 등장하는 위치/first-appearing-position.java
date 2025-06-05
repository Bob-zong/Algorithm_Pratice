import java.util.*;
import java.io.*;
import java.util.Map.*;


public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            m.put(num, m.getOrDefault(num, i));
        }
        Iterator<Entry<Integer, Integer>> it = m.entrySet().iterator();
        while(it.hasNext()){
            Entry<Integer, Integer> entry = it.next();
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.print(sb);
    }
}