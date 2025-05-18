import java.util.*;
import java.io.*;

public class Main {
    public static long m;
    
    public static int binary_search(int target) {
        long left = 1;
        long right = m;
        int cnt = 0;

        while(left <= right) {
            cnt++;

            long mid = (left + right) / 2;

            if(mid == target){
                break;
            }

            if(mid > target)
                right = mid - 1;
            else
                left = mid + 1;
            
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int x1, x2;

        x1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());

        int min, max;

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for(int i = x1; i <= x2; i++) {
            int ans = binary_search(i);
            min = Math.min(min, ans);
            max = Math.max(max, ans);
        }

        System.out.print(min + " " + max);
        
    }
}