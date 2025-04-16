import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a, b, c;

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // a * x + b * y <= C

        int maxNum = 0;
        int maxA = c / a;
        int maxB = c / b;


        for(int i = 0; i <= maxA; i++){
            int sum = a * i;
            for(int j = 0; j <= maxB; j++){
                sum += b;
                if(sum <= c){
                    maxNum = Math.max(sum, maxNum);
                }
            }
        }

        System.out.print(maxNum);
    }
}