import java.util.*;
import java.io.*;

public class Main {
    public static int N, K, B;
    public static int[] answer;
    public static int[] prefixSum;

    public static int getSum(int s, int e) {
        return prefixSum[e] - prefixSum[s-1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        answer = new int[N+1];
        prefixSum = new int[N+1];
        // 얘를 누적합으로 풀려면
        // 누적합 만드는데 O(N)
        // 모든 인덱스에 대해서 1로 채워넣고
        // 누적합을 만들어
        // 값을 비교해서 몇개가 빠져있는지 확인 가능해.
        //O(N)으로 최소 연속된 수를 구할 수 있어.
        Arrays.fill(answer, 1, N+1 , 1);

        for(int i = 0; i < B; i++){
            int num = Integer.parseInt(br.readLine());
            answer[num] -= 1;
        }

        for(int i = 1; i <= N; i++){
            prefixSum[i] = prefixSum[i-1] + answer[i];
        }
        
        int ans = Integer.MAX_VALUE;

        for(int i = 1; i <= N - K + 1; i++) {
            int diff = K - getSum(i, i + K - 1);
            ans = Math.min(ans, diff);
        }
        
        System.out.print(ans);
    }
}