import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = 15;
        int[] answer = new int[n];

        for(int i = 0; i < n; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(answer);


        int a = answer[0];
        int b = answer[1];
        int c = answer[2];
        int d = answer[n-1] - (a+b+c);
        System.out.printf("%d %d %d %d", a, b, c, d);
        // a + b >= c


    }
}