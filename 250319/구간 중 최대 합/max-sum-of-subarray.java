import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int answer[] = new int[n];

        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for(int i = 0; i < n - k + 1; i++){
            int sum = 0;
            for(int j = i; j < i + k; j++){
                sum += answer[j];
            }
            ans = Math.max(sum, ans);
        }

        System.out.print(ans);
    }
}