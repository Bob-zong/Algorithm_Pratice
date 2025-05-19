import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] answer;

    public static boolean isPossible(int maxValue) {
        int ans = 0;

        for(int i = 1; i <= n; i++) {
            ans += answer[i] / maxValue;
        }

        if(ans >= m)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n+1];
        
        int sum = 0;
        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(br.readLine());
            sum += answer[i];
        }
            

        Arrays.sort(answer, 1, n+1);

        int left = 1;
        int right = sum / m;
        int ans = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(mid)) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
            else{
                right = mid - 1;
            }
        }

        System.out.print(ans);
    }
}