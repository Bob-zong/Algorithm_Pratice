import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_TIME = (int)1e9;
    public static int n, m, c;
    public static int[] time;
    public static int ans = MAX_TIME;

    public static boolean isPossible(int mid) {
        int cnt = 1; // 현재 사용 중인 버스 수
        int first = 0; // 현재 버스에 태운 첫 사람 인덱스

        for (int i = 1; i < n; i++) {
            // 현재 버스에 태울 수 없는 경우 → 새 버스 필요
            if (i - first >= c || time[i] - time[first] > mid) {
                cnt++;
                first = i;
            }
        }

        return cnt <= m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        time = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        int left = 0, right = MAX_TIME;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(ans);
    }
}
