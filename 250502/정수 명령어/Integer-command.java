import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        TreeSet<Integer> ts = new TreeSet<>();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(cmd.equals("I")){
                    ts.add(num);
                }
                else if(cmd.equals("D")){
                    if(ts.isEmpty())
                        continue;
                        // sb.append("EMPTY").append("\n");
                    else if(num == 1)
                        ts.remove(ts.last());
                    else if(num == -1)
                        ts.remove(ts.first());
                }

            }

            if(ts.isEmpty()){
                sb.append("EMPTY").append("\n");
            }
            else{
                sb.append(ts.last()).append(" ").append(ts.first()).append("\n");
            }
        }

        System.out.print(sb);
    }
}