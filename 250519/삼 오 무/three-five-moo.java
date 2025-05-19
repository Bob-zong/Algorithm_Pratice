import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    // 5 => order = 5 - 1 - 1 + 0 = 3
    // 3 => 3 - 1 - 0 + 0 = 2;
    // target = 5 -> 1 + 1+ 0 -> 2 
    // 5 - 2 = 3

    public static long isPossible(long k) {
        long order = (k / 3) + (k / 5) - (k / 15);
        // int order = 0;
        // order += k /3;
        // order += k /5;
        // order -= k/15;

        // order = k - order;
        return k - order;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        long left = 1;
        long right = Integer.MAX_VALUE;
        long ans = Integer.MAX_VALUE;
        // 해당 값에서 3의 배수 + 5의 배수 - 15의 배수 하면 몇 번째인지 나올 거 아니야?

        while(left <= right) {
            long mid = (left + right) / 2;

            if(isPossible(mid) >= n){
                right = mid - 1;
                ans = Math.min(ans, mid);
                // 1755433922
            }
            else{
                left = mid + 1;
            }


        }

        System.out.print(ans);
    }
}