import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        int k = Integer.parseInt(st.nextToken());
        int len = str.length();
        char[] answer = str.toCharArray();

        int[] count = new int[26];
        int unique = 0;
        int ans = 0;
        int j = 0;

        for (int i = 0; i < len; i++) {
            while (j < len) {
                int idx = answer[j] - 'a';
                if (count[idx] == 0 && unique == k) break;

                if (count[idx] == 0) unique++;
                count[idx]++;
                j++;
            }

            ans = Math.max(ans, j - i);

            // 윈도우 왼쪽 줄이기
            int idx = answer[i] - 'a';
            count[idx]--;
            if (count[idx] == 0) unique--;
        }

        System.out.println(ans);
    }
}
