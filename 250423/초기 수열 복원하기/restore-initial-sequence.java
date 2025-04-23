import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] sumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        sumArr = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n - 1; i++) {
            sumArr[i] = Integer.parseInt(st.nextToken());
        }

        // A[0]을 1부터 n까지 시도
        for (int first = 1; first <= n; first++) {
            int[] A = new int[n];
            A[0] = first;
            boolean valid = true;

            for (int i = 1; i < n; i++) {
                A[i] = sumArr[i - 1] - A[i - 1];
                if (A[i] < 1 || A[i] > n) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                // 중복 확인
                Set<Integer> set = new HashSet<>();
                for (int a : A) set.add(a);

                if (set.size() == n) {
                    for (int i = 0; i < n; i++) {
                        System.out.print(A[i] + " ");
                    }
                    return;
                }
            }
        }
    }
}
