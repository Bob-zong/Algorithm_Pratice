import java.util.*;

public class Main {
    public static final int MAX_N = 50000;

    public static int[] arr = new int[MAX_N + 1];
    public static int[] L = new int[MAX_N + 1];
    public static int[] R = new int[MAX_N + 2];
    public static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 1, n + 1);

        // L[i]: 1 ~ i까지 중에서 오른쪽으로 확장 가능한 최대 구간 길이
        int j = 1;
        for (int i = 1; i <= n; i++) {
            while (j <= n && arr[j] - arr[i] <= k)
                j++;

            int len = j - i;
            L[i] = len;
        }

        // 누적 최댓값: L[i] ← max(L[1..i])
        for (int i = 2; i <= n; i++)
            L[i] = Math.max(L[i], L[i - 1]);

        // R[i]: i ~ n까지 중에서 오른쪽으로 확장 가능한 최대 구간 길이
        j = 1;
        for (int i = 1; i <= n; i++) {
            while (j <= n && arr[j] - arr[i] <= k)
                j++;

            int len = j - i;
            R[i] = len;
        }

        // 누적 최댓값: R[i] ← max(R[i..n])
        for (int i = n - 1; i >= 1; i--)
            R[i] = Math.max(R[i], R[i + 1]);

        // 두 그룹을 나눠서 최댓값 합 구하기
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, L[i] + R[i + 1]);
        }

        // 하나의 그룹만 사용하는 경우도 포함
        ans = Math.max(ans, L[n]);

        System.out.println(ans);
    }
}
