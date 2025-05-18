import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] answer;

    public static int lower_bound(int start , int end) {
        int left = 1;
        int right = n;
        int minIdx = n;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(answer[mid] >= start)
                right = mid - 1;
            else
                left = mid + 1;
            
        }

        return right;
    }
    public static int findMax(int start, int end) {
        int l = 1;
        int r = n;

        while(l <= r) {
            int mid = (l + r) / 2;
            if(answer[mid] > end)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return r;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++)
            answer[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(answer);


        for(int i = 0;i < m; i++) {
            st= new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int min = lower_bound(x1, x2);
            int max = findMax(x1, x2);

            sb.append(max - min).append("\n");
            
        }
        System.out.print(sb);
    }
}