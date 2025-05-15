import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();
        char[] answer = str.toCharArray();

        int[] countArr = new int[26];
        int ans = 0;
        int j = 0;

        for (int i = 0; i < len; i++) {
            while (j < len && countArr[answer[j] - 'a'] == 0) {
                countArr[answer[j] - 'a']++;
                ans = Math.max(ans, j - i + 1);
                j++;
            }

            // 현재 i 문자 제거하고 다음으로
            countArr[answer[i] - 'a']--;
        }

        System.out.println(ans);
    }
}
