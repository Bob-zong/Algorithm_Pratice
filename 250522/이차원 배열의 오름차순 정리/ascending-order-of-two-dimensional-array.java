import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long left = 1, right = n * n, answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            // mid보다 작거나 같은 수가 몇 개인지 카운트
            long cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(n, mid / i);
            }

            if (cnt >= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
