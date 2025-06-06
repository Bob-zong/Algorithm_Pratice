import java.util.*;
import java.io.*;

public class Main {
    public static long m;
    
    public static int binary_search(long target) {
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

        m = Long.parseLong(br.readLine());

        st = new StringTokenizer(br.readLine());

        long x1, x2;

        x1 = Long.parseLong(st.nextToken());
        x2 = Long.parseLong(st.nextToken());

        int min, max;

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for(long i = x1; i <= x2; i++) {
            int ans = binary_search(i);
            min = Math.min(min, ans);
            max = Math.max(max, ans);
        }

        System.out.print(min + " " + max);
        
    }
}