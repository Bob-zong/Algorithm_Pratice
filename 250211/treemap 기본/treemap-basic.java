import java.util.*;
import java.io.*;
import java.util.Map.Entry;
public class Main {
    public static void main(String[] args) throws IOException {
        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("add")){
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                treemap.put(num1, num2);
                // sb.append(treemap.get(num1) + treemap.get(num2)).append("\n");
            }
            else if(op.equals("find")){
                int num1 = Integer.parseInt(st.nextToken());
                if(treemap.containsKey(num1)){
                    sb.append(treemap.get(num1)).append("\n");
                }else{
                    sb.append("None").append("\n");
                }
            }
            else if(op.equals("remove")){
                int num1 = Integer.parseInt(st.nextToken());
                treemap.remove(num1);
            }
            else if(op.equals("print_list")){
                if(treemap.isEmpty()) {
                    sb.append("None").append("\n");
                    continue;
                }
                Iterator<Entry<Integer, Integer>> it = treemap.entrySet().iterator();
                while(it.hasNext()){
                    Entry<Integer, Integer> entry = it.next();
                    sb.append(entry.getValue()).append(" ");
                }
                sb.append("\n");
            }
            
        }
        System.out.print(sb);
        

    }
}