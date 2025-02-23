import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] answer = new int[501];
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int candyNum = Integer.parseInt(st.nextToken());
            int candyPos = Integer.parseInt(st.nextToken());
            answer[candyPos] += candyNum;
        }

        int MaxCandyCnt = 0;

        for(int i = 0; i <= 500-(2*k+1); i++){
            int cnt1 = 0;
            // int cnt2 = 0;

            for(int j = 0; j < 2*k+1; j++){
                cnt1 += answer[i+j];
            }
            // int sum = cnt1 + cnt2 + answer[i];
            MaxCandyCnt = Math.max(MaxCandyCnt, cnt1);
        }

        System.out.print(MaxCandyCnt);

    }
}