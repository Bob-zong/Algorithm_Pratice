import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        HashSet<Integer> hs = new HashSet<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(cmd.equals("add")){
                hs.add(num);
            }
            else if(cmd.equals("remove")){
                hs.remove(num);
            }
            else{
                if(hs.contains(num)){
                    sb.append("true").append("\n");
                }else sb.append("false").append("\n");
            }
        }

        System.out.print(sb);

    }
}