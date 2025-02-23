import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] answer = new int[100];
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int candyNum = Integer.parseInt(st.nextToken());
            int candyPos = Integer.parseInt(st.nextToken());
            answer[candyPos] = candyNum;
        }

        int MaxCandyCnt = 0;

        for(int i = k; i < 100 - k; i++){
            int cnt1 = 0;
            int cnt2 = 0;

            for(int j = 1; j <= k; j++){
                cnt1 += answer[i+j];
                cnt2 += answer[i-j];
            }
            int sum = cnt1 + cnt2 + answer[i];
            MaxCandyCnt = Math.max(MaxCandyCnt, sum);
        }

        System.out.print(MaxCandyCnt);

    }
}