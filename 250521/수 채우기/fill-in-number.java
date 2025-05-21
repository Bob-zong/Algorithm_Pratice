import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = -1;

        for (int fiveCnt = n / 5; fiveCnt >= 0; fiveCnt--) {
            int remain = n - (fiveCnt * 5);
            if (remain % 2 == 0) {
                int twoCnt = remain / 2;
                ans = fiveCnt + twoCnt;
                break;
            }
        }

        System.out.println(ans);
    }
}
