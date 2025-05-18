import java.util.*;
import java.io.*;

public class Main {
    public static long s, n;

    public static long binary_search() {
        long left = 1;
        long right = s;
        long maxNum = 1;

        while(left <= right) {
            long mid = (left + right) / 2;
            if(mid * (mid + 1) / 2  <= s) {
                left = mid + 1;
                maxNum = Math.max(maxNum, mid);
            }
            else{
                right = mid - 1;
            }
        }

        return maxNum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = Long.parseLong(br.readLine());

        long ans = binary_search();
        System.out.print(ans);
    }
}