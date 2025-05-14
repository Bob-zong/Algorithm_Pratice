import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] answer = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++)
            answer[i] = Integer.parseInt(st.nextToken());
        
        int j = 0;

        int ans = 0;
        int sumVal = 0;

        for(int i = 1; i <= n; i++){

            while(j + 1 <= n && sumVal + answer[j+1] <= m){
                sumVal += answer[j+1];
                j++;
                // sumVal = 1, j = 1
                // sum = 4 j = 2;
                // sum 6 j = 3
                // sum 10 j = 4
                // sum 9 j = 4
                // i = 3, sum 6, j = 4
            }

            if(sumVal == m)
                ans += 1;
            
            sumVal -= answer[i];
        }

        System.out.print(ans);

    }
}