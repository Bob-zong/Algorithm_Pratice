import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int num = -1 * Integer.parseInt(st.nextToken());
            pq.add(num);
        }

        boolean condition = true;
        while(condition) {
            if(pq.size() <= 1)
                break;

            int num1 = pq.poll(); 
            int num2 = pq.poll(); 
            int result = num1 - num2;
            if(result != 0)
                pq.add(result);
                        
        }

        System.out.print(pq.size());
    }
}