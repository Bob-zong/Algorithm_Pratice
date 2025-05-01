import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num != 0) {
                pq.add(-1 * num);
            }else{
                if(pq.isEmpty())
                    sb.append(0).append("\n");
                else{
                    int val = -1 * pq.poll();
                    sb.append(val).append("\n");
                }
                    
            }
        }
        System.out.print(sb);
    }
}