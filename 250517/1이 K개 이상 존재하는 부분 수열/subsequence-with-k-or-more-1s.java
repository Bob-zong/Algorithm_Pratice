import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_INT = Integer.MAX_VALUE;
    public static int[] countArr = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, k;

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] answer = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++)
            answer[i] = Integer.parseInt(st.nextToken());


        int ans = MAX_INT;
        int j = 0;

        for(int i = 1; i <= n; i++) {

            while(j + 1 <= n && countArr[1] < k) {
                countArr[answer[j+1]]++;
                j++;
            }

            if(countArr[1] >= k)
                ans = Math.min(ans, j - i + 1);

            countArr[answer[i]]--;
        }

        System.out.print(ans);

    }
}