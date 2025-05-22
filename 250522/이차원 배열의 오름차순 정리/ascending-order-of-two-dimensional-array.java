import java.util.*;
import java.io.*;

public class Main {
    public static int n, order;
    public static int answer = 0;

    public static void binary_search() {
        int left = 1;
        int right = n * n;

        while(left <= right) {
            int mid = (left + right) / 2;
            long cnt = 0;
            for(int i = 1; i <= n; i++){
                cnt += Math.min(n, mid / i);
            }

            if(cnt >= order) {
                    right = mid-1;
                    answer = mid;
                }
            else 
                left = mid+1;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        order = Integer.parseInt(br.readLine());
        binary_search();
        System.out.print(answer);
    }
}


