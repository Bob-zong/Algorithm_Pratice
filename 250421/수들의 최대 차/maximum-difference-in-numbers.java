import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] answer = new int[n];

        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(answer);
        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = n-1; j > i; j--){
                if(answer[j] - answer[i] <= k)
                    ans = Math.max(ans, j-i+1);
            }

        }
        System.out.print(ans);
    }
}