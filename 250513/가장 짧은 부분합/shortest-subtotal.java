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
        int[] answer = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        int ans = MAX_NUM;
        long sumVal = 0;
        int j = 1;

        for (int i = 1; i <= n; i++) {
            while (j <= n && sumVal < s) {
                sumVal += answer[j];
                j++;
            }

            if (sumVal >= s) {
                ans = Math.min(ans, j - i);
            }

            sumVal -= answer[i];
        }

        System.out.println(ans == MAX_NUM ? -1 : ans);
    }
}
