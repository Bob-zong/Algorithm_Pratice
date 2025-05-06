import java.util.*;
import java.io.*;
import java.util.Map.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st;
        TreeMap<String, Integer> m = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String str = br.readLine();

            if(m.containsKey(str)){
                m.put(str, m.get(str) + 1);
            }else{
                m.put(str, 1);
            }
        }

        Iterator<Entry<String, Integer>> it = m.entrySet().iterator();
        while(it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            double ratio = ((double)entry.getValue() / n) * 100;
            sb.append(String.format("%s %.4f", entry.getKey(), ratio));
            sb.append("\n");
        }

        System.out.print(sb);

    }
}