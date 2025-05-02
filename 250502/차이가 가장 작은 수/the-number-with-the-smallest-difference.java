import java.util.*;
import java.io.*;

public class Main {
    public static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> s = new TreeSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            s.add(arr[i]);
        }
        
        // | x - r | >= m
        // x - r >= m -> r <= x - m 일 때 최대 값 r 을 구하는 경우
        // r - x >= m -> r >= m + x

        for(int i = 0; i < n; i++) {
            int x = arr[i];
            if(s.ceiling(m+x) != null)
                ans = Math.min(ans, s.ceiling(m + x) - x);
            if(s.floor(x - m) != null)
                ans = Math.min(ans, x - s.floor(x - m));
        }
        if(ans != Integer.MAX_VALUE)
            System.out.print(ans);
        else
            System.out.print(-1);
        
    }
}