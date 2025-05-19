import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static boolean isPossible(int k) {
        int order = k - (k / 3) - (k / 5) + (k / 15);

        if(order >= n)
            return true;
        else
            return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        int left = 1;
        int right = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        // 해당 값에서 3의 배수 + 5의 배수 - 15의 배수 하면 몇 번째인지 나올 거 아니야?

        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)){
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
            else{
                left = mid + 1;
            }


        }

        System.out.print(ans);
    }
}