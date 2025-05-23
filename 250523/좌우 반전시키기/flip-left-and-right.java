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

        answer = new int[n];

        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for(int i = 1; i < n; i++){
            if(answer[i-1] == 0){
                ans++;
                answer[i - 1] = 1;
                answer[i] = (answer[i] + 1) % 2;
            }

            if(i + 1 < n) {
                answer[i+1] = (answer[i+1] + 1) % 2;
            }
        }

        if(answer[n-1] == 0)
            ans = -1;

        System.out.print(ans);
    }
}