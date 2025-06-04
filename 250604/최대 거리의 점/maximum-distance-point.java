import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NUM = 1000000000;
    public static final int MAX_N = 200000;

    public static int n, m;
    public static int[] answer = new int[MAX_N];

    
    public static boolean isPossible(int dist) {
        int cnt = 1;
        int lastIdx = 0;

        for(int i = 1; i < n; i++) {
            if(Math.abs(answer[i] - answer[lastIdx]) >= dist){
                cnt++;
                lastIdx = i;
            }
        }

        return cnt >= m;
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++)
            answer[i] = Integer.parseInt(br.readLine());

        Arrays.sort(answer, 0 , n);

        int left = 1;
        int right = MAX_NUM;
        int ans = 0 ;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(mid)){
                left = mid + 1;
                ans =  Math.max(ans, mid);
            }
            else
                right = mid - 1;
        }


        System.out.print(ans);
        
    }
}