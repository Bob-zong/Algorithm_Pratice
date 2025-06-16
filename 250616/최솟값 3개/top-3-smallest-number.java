import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            long ans = -1;
            q.add(num);

            if(q.size() >= 3){
                int num1, num2, num3;

                num1 = q.poll();
                num2 = q.poll();
                num3 = q.poll();

                ans = (long)num1 * num2 * num3;

                sb.append(ans).append("\n");

                q.add(num1);
                q.add(num2);
                q.add(num3);
            }
            else{
                sb.append(ans).append("\n");
            }
            
            
        }

        System.out.print(sb);
    }
}