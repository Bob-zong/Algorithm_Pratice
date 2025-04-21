import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        str = br.readLine();

        int ans = 0;

        // 길이 1부터 n까지 확인
        for (int len = 1; len <= n; len++) {
            Set<String> set = new HashSet<>();
            boolean duplicated = false;

            // 길이 len의 substring을 set에 넣으며 중복 확인
            for (int i = 0; i <= n - len; i++) {
                String sub = str.substring(i, i + len);

                if (set.contains(sub)) {
                    duplicated = true;
                    break;
                }
                set.add(sub);
            }

            // 중복이 없다면 그 길이가 정답
            if (!duplicated) {
                ans = len;
                break;  // 더 짧은 길이는 어차피 불가능하니 바로 종료
            }
        }

        System.out.print(ans);
    }
}
