import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int ans;

    public static int[] answer;

    public static void choose(int currNum, int cnt) {
        if(currNum >= n) {
            return;
        }

        if(currNum == n-1){
            ans = Math.min(ans, cnt);
            return;
        }

        for(int i = 1; i <= answer[currNum]; i++) {
            choose(currNum + i, cnt + 1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        answer = new int[n];
        ans = n;

        for(int i = 0; i < n; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        choose(0, 0);
        
        if(ans == n)
            System.out.print(-1);
        else{
            System.out.print(ans);
        }
        
    }   
}