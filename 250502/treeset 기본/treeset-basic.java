import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeSet<Integer> ts = new TreeSet<>();
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("add")){
                int x = Integer.parseInt(st.nextToken());
                ts.add(x);
            }
            else if(cmd.equals("remove")){
                int x = Integer.parseInt(st.nextToken());
                ts.remove(x);
            }
            else if(cmd.equals("find")){
                int x = Integer.parseInt(st.nextToken());
                if(ts.contains(x)){
                    sb.append("true");
                }else   sb.append("false");

                sb.append("\n");
            }
            else if(cmd.equals("lower_bound")){
                int x = Integer.parseInt(st.nextToken());
                
                if(ts.ceiling(x) != null)
                    sb.append(ts.ceiling(x)).append("\n");
                else    sb.append("None").append("\n");
            }
            else if(cmd.equals("upper_bound")){
                int x = Integer.parseInt(st.nextToken());
                if(ts.higher(x) != null)
                    sb.append(ts.higher(x)).append("\n");
                else    sb.append("None").append("\n");
            }
            else if(cmd.equals("largest")){
                if(!ts.isEmpty())
                    sb.append(ts.last()).append("\n");
                else    sb.append("None").append("\n");
            }
            else if(cmd.equals("smallest")){
                if(!ts.isEmpty())
                    sb.append(ts.first()).append("\n");
                else    sb.append("None").append("\n");
            }
        }

        System.out.print(sb);
    }
}