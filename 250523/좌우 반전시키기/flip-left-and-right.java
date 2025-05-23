import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] answer;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        answer = new int[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for(int i = 1; i <= n; i++) {
            if(i == n && answer[n] == 0){
                ans = -1;
                break;
            }

            if(answer[i] == 1)
                continue;
            
            if(answer[i] == 0){
                answer[i+1] = (answer[i+1] + 1) % 2;
                answer[i+2] = (answer[i+2] + 1) % 2;
                ans++;
            }
        }

        System.out.print(ans);
    }
}