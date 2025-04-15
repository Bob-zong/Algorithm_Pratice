import java.util.*;
import java.io.*;

public class Main {
    // S까지의 거리 d1이 N까지의 거리 d2 보다 작거나 같은 경우 k 값이 특별한 위치가 된다.

    public static int T, a, b;
    public static final int MAXNUM = 1000;
    public static int[] answer;
    public static final int MAXVALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());


        answer = new int[MAXNUM+1];

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            char ch = str.charAt(0);
            int num = Integer.parseInt(st.nextToken());
            if(ch == 'S')
                answer[num] = 1;
            else
                answer[num] = 2;
        }

        int cnt = 0;

        for(int i = a; i <= b; i++){
            int sDist = Integer.MAX_VALUE;
            int nDist = Integer.MAX_VALUE;

            for(int j = 1; j <= 1000; j++){
                if(answer[j] == 1)
                    sDist = Math.min(sDist, Math.abs(j - i));
                else if(answer[j] == 2){ 
                    nDist = Math.min(nDist, Math.abs(j - i));
                }
            }

            if(sDist <= nDist && sDist != MAXVALUE && nDist != MAXVALUE)
                cnt += 1;
        }

        System.out.print(cnt);
    }
}