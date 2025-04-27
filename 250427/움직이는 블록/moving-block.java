import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] answer = new int[n];
        long[] prefixSum = new long[n+1];  // 누적합을 저장할 배열 (prefixSum[0] = 0)

        // 값 입력 및 누적합 계산
        for (int i = 0; i < n; i++) {
            answer[i] = Integer.parseInt(br.readLine());
            prefixSum[i+1] = prefixSum[i] + answer[i];  // 현재까지의 누적합
        }

        // 총합을 구하는 대신, 누적합을 활용하여 평균을 구할 수 있음
        long totalSum = prefixSum[n];
        long average = totalSum / n;

        long ans = 0;
        // 평균보다 큰 값들에 대해서 차이를 누적합으로 계산
        for (int i = 0; i < n; i++) {
            if (answer[i] > average) {
                ans += answer[i] - average;
            }
        }

        System.out.print(ans);
    }
}
