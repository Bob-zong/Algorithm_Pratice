import java.util.*;
import java.io.*;

// 배열을 음수용 , 양수용 만들어서
// 1 ~ n까지 돌려서 사이
public class Main {
    public static final int MAX_N = 100000;
    public static int[] answer = new int[MAX_N+1];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            int num = Integer.parseInt(st.nextToken());

            answer[i] = num; 
        }

        Arrays.sort(answer, 1, n+1);

        int j = n;
        int ans = Integer.MAX_VALUE;

        // 1 2 3 4 5 6 -> 
        for(int i = 1; i <= n; i++) {
            if(i < j)
                ans = Math.min(ans, Math.abs(answer[i] + answer[j]));

            while(i < j-1 && answer[i] + answer[j] > 0){
                j--;
                ans = Math.min(ans, Math.abs(answer[i] + answer[j]));
            }

            if(i > j)
                break;
        }
         
        System.out.print(ans);
    }
}