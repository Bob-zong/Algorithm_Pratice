import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] developer1;
    public static int[] developer2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());

        developer1 = new int[n];
        developer2 = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            developer1[i] = Integer.parseInt(st.nextToken());
            developer2[i] = Integer.parseInt(st.nextToken());
        }

        int maxWinCnt = 0;

        // 1이 2를 이기고 2가 3을 이기고 3이 1을 이기는 경우
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        
        for(int i = 0; i < n; i++){
            // 1번 주먹 2번 가위 3번 보
            if(developer1[i] == 1 && developer2[i] == 2 ||
                developer1[i] == 2 && developer2[i] == 3 ||
                developer1[i] == 3 && developer2[i] == 1
            ) cnt1 += 1;
            // 이긴 횟수 

            //비긴 횟수
            if(developer1[i] == developer2[i])
                cnt2 += 1;        
        }
        //진 횟수
        cnt3 = n - cnt2 - cnt1;

        maxWinCnt = Math.max(maxWinCnt, Math.max(cnt1, Math.max(cnt2, cnt3)));

        System.out.print(maxWinCnt);
        

    }
}