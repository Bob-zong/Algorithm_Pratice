import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NUM = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[MAX_NUM + 1];
        int[] countArr = new int[MAX_NUM + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        int j = 0;
        int ans = 0;

        for(int i = 1; i <= n; i++) {
            
            while(j+1 <= n && countArr[answer[j+1]] == 0) {
                countArr[answer[j+1]] += 1;
                j++;
            }

            ans = Math.max(ans, j - i + 1);
            countArr[answer[i]] -= 1;
        }

        System.out.print(ans);

    }
}