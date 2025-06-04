import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String originStr = br.readLine();
        String targetStr = br.readLine();

        char[] origin = originStr.toCharArray();
        char[] target = targetStr.toCharArray();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (origin[i] != target[i]) {
                ans++;
                // 최대 4칸까지 고칠 수 있으므로, i부터 i+3까지 다 고쳐버리자
                for (int j = i; j < i + 4 && j < n; j++) {
                    origin[j] = target[j];
                }
            }
        }

        System.out.print(ans);
    }
}
