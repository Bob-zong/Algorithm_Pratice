import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_NUM = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] answer = new int[MAX_NUM+1];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            String ch = st.nextToken();
            answer[pos] = ch.equals("G") ? 1 : 2;
        }
        
        int maxScale = 0;

        for(int i = 1; i <= MAX_NUM; i++){
            if(answer[i] == 0)
                continue;
            int gCnt = 0;
            int hCnt = 0;

            for(int j = i; j <= MAX_NUM; j++){
                if(answer[j] == 0)
                    continue;
                else if(answer[j] == 1)
                    gCnt += 1;
                else if(answer[j] == 2)
                    hCnt += 1;
                
                if(gCnt == 0 || hCnt == 0 || gCnt == hCnt)
                    maxScale = Math.max(maxScale, j-i);
            }
        }
        System.out.print(maxScale);
        
    }
}