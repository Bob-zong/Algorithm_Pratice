import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            
            if(cmd.equals("push")){
                int num = -1 * Integer.parseInt(st.nextToken());
                pq.add(num);
            }
            else if(cmd.equals("size")){
                sb.append(pq.size()).append("\n");
            }
            else if(cmd.equals("pop")){
                sb.append(-1 * pq.poll()).append("\n");
            }
            else if(cmd.equals("empty")){
                if (pq.isEmpty())
                    sb.append(1);
                else
                    sb.append(0);

                sb.append("\n");
            }
            else if(cmd.equals("top")){
                sb.append(-1 * pq.peek()).append("\n");
            }
        }

        System.out.print(sb);
    }
}