import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> m = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= n; i++){
            String str = br.readLine();

            m.put(str, m.getOrDefault(str, 0) + 1);
        }
        Iterator<Entry<String, Integer>> it = m.entrySet().iterator(); 

        while(it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        
        System.out.print(sb);
    }
}