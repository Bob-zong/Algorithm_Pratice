import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        answer = new int[n+1];

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        int idx = 2;

        while(idx < n) {
            if(answer[idx-1] == 0){
                answer[idx-1] = (answer[idx-1] + 1) % 2;
                answer[idx] = (answer[idx] + 1) % 2;
                answer[idx+1] = (answer[idx+1] + 1) % 2;
                ans++;
            }

            idx++;
        }
        
        if(answer[n-1] == 0 || answer[n] == 0)
            ans = -1;

        System.out.print(ans);
    }
}