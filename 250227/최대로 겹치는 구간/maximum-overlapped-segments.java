import java.util.*;
import java.io.*;

public class Main {
    static final int OFFSET = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] answer = new int[201];


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int x1, x2;
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());

            x1 += OFFSET;
            x2 += OFFSET;

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