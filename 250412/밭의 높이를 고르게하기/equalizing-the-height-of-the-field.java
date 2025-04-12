import java.util.*;
import java.io.*;

public class Main {
    // 1 ~ n까지 돌면서 각 인덱스에서 T만큼을 H로 만들기 위해 비용 계산
    // 최소값일 때 갱신
    // n번 돌고 -> O(n)
    // idx ~ idx + t 만큼 계산 O(T)
    // 
    public static int n, h, t;
    public static int[] answer;
    public static int minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        answer = new int[n];
        minCost = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        int len = st.countTokens();
        // System.out.print(len);
        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= n - t; i++){
            int cost = 0;
            for(int j = i; j < i + t; j++){
                cost += Math.abs(answer[j] - h);
                
            }
            minCost = Math.min(minCost, cost);
        }

        System.out.print(minCost);

    }
}