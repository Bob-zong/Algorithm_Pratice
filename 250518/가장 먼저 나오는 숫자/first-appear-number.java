import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] answer;


    public static int binary_search(int target) {
        int left = 1;
        int right = n;
        int minIdx = n;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(answer[mid] >= target){
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else {
                left = mid + 1;
            }

        }
        if(target == answer[minIdx])
            return minIdx;
        else
            return -1; 
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

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int ans = Integer.parseInt(st.nextToken());
            ans = binary_search(ans);
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}