import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int left = max;
        int right = sum;
        int result = sum;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(arr, M, mid)) {
                result = mid;       // 가능한 경우 저장
                right = mid - 1;    // 더 작은 값 탐색
            } else {
                left = mid + 1;     // 더 큰 값 필요
            }
        }

        System.out.println(result);
    }

    public static boolean isPossible(int[] arr, int M, int maxSum) {
        int count = 1;
        int tempSum = 0;

        for (int num : arr) {
            if (tempSum + num > maxSum) {
                count++;
                tempSum = num;
            } else {
                tempSum += num;
            }
        }

        return count <= M;
    }
}
