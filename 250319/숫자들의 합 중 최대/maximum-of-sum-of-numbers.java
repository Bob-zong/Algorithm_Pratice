import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int ans = 0;

        for(int i = num1; i <= num2; i++){
            int sum = 0;

            int d1 = i / 10000;
            int d2 = (i / 1000) % 10;
            int d3 = (i / 100) % 10;
            int d4 = (i / 10) % 10;
            int d5 = i % 10; 
            // System.out.printf("%d %d %d %d %d \n", d1, d2,d3,d4,d5);
            sum = d1 + d2 + d3 + d4 + d5;
            ans = Math.max(ans, sum);
        }
        System.out.print(ans);
    }
}