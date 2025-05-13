import java.util.*;
import java.io.*;

public class Main {
    public static int n, s;
    public static final int MAX_NUM = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        long[] answer = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        int ans = MAX_NUM;
        long sumVal = 0;

        int j = 1;

        for(int i = 1; i <= n; i++) {
                
            while(j <= n && sumVal + answer[j] < s) {
                sumVal += answer[j];
                j++;
            }
            
            ans = Math.min(ans, j-i+1);
            

            sumVal -= answer[i];
        }

        if(ans == MAX_NUM)
            System.out.print(-1);
        else System.out.print(ans);
        

        // Please write your code here.
    }
}