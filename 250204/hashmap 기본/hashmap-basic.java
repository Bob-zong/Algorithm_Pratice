import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("add")){
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                map.put(key, value);
            }
            else if(command.equals("find")){
                int key = Integer.parseInt(st.nextToken());
                if(map.containsKey(key)){
                    // sb.append(Integer.toString(map.get(key)));
                    sb.append(map.get(key));
                    sb.append("\n");
                }
                else{
                    sb.append("None\n");
                }
            }
            else if(command.equals("remove")){
                int key = Integer.parseInt(st.nextToken());
                map.remove(key);
            }
        }
        System.out.print(sb);

    }
}