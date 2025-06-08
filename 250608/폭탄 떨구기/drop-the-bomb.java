import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] line;
    public static int ans;
    
    public static boolean isPossible(int dist) {
        int cnt = 1;
        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(line[i] - line[idx] <= 2 * dist) continue;
            else {
                cnt++;
                idx = i;
            }
        }

        return cnt <= k;
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        line = new int[n];

        for(int i = 0; i < n; i++){
            line[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(line);

        
        int left = 0;
        int right = (int) 1e9;
        ans = (int) 1e9;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)){
                ans = Math.min(ans, mid);
                right = mid - 1;
            }
            else
                left = mid + 1;

        }

        System.out.print(ans);

    }
}