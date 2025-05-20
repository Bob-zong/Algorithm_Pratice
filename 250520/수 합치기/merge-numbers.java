import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        

        
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i< n; i++){
            q.add(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        while(q.size() != 1) {
            int num1 = q.poll();
            int num2 = q.poll();
            ans += num1 + num2;

            q.add(num1 + num2);
        }

        System.out.print(ans);
    }
}