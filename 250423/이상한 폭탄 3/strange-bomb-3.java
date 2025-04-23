import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] answer;

    public static int Boom(int startIdx, int boomNum) {
        int cnt = 0;
        for(int i = 1; i <= k; i++){
            if((startIdx + i < n) && answer[startIdx + i] == boomNum){
                cnt += 1;
            }
            if((startIdx - i >= 0) && answer[startIdx - i] == boomNum)
                cnt += 1;
        }
        if(cnt != 0){
            return cnt+1;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        answer = new int[n];

        for(int i = 0; i < n; i++)
            answer[i] = Integer.parseInt(br.readLine());

        int maxBoomNum = 0;
        int maxCnt = 0;
        for(int i = 0; i < n; i++){
            int cnt = Boom(i, answer[i]);
            if(cnt >= maxCnt && cnt != 0){
                maxBoomNum = Math.max(answer[i], maxBoomNum);
                maxCnt = cnt;
            }
        }


        if(maxCnt == 0)
            System.out.print(0);
        else
            System.out.print(maxBoomNum);
    }
}