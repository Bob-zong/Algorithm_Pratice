import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] answer = new int[201];


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int x1, x2;
            x1 = Integer.parseInt(st.nextToken());
            if(x1 < 0)
                x1 += 100;

            x2 = Integer.parseInt(st.nextToken());
            if(x2 < 0)
                x2 += 100;

            for(int j = x1; j < x2; j++){
                answer[j] += 1;
            }
        }
        int max = 0;

        for(int i = 1; i <= 200; i++){
            max = Math.max(max, answer[i]);
        }
        System.out.print(max);
    }
}