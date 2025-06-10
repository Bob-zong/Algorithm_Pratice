import java.util.*;
import java.io.*;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 10;
    public static int ans = INT_MAX;

    public static int n;
    public static int[] num = new int[2 * MAX_N];
    public static boolean[] visited = new boolean[2 * MAX_N];

    public static void choose(int currNum, int cnt) {
        
    }

    public static int calc() {
        int diff = 0;
        for(int i = 0; i < 2 * n; i++)
            diff = (visited[i]) ? (diff + num[i]) : (diff - num[i]);
        
        return Math.abs(diff);
    }
    public static void findMin(int idx, int cnt) {
        if(cnt == n) {
            ans = Math.min(ans, calc());
            return;
        }
        
        if(idx == 2 * n)
            return;
        
        // 현재 숫자를 첫 번째 그룹에 사용한 경우입니다.
        visited[idx] = true;
        findMin(idx + 1, cnt + 1);
        visited[idx] = false;
        
        // 현재 숫자를 두 번째 그룹에 사용한 경우입니다.
        findMin(idx + 1, cnt);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 2 * n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        findMin(0, 0);

        System.out.print(ans);
    }
}