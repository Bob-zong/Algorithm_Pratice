import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100000;
    public static int[] L = new int[MAX_N];
    public static int[] R = new int[MAX_N];
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] B = new int[n];

        //주먹: 1 가위: 2 보: 3

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            char ch = str.charAt(0);
            int value = 0;
            if(ch == 'H')
                value = 1;
            else if(ch == 'S')
                value = 2;
            else
                value = 3;
            
            B[i] = value;
        }

        for(int i = 1; i <= 3; i++){
            int sameCnt = 0;

            for(int j = 0; j < n; j++){
                if(B[j] == i) {
                    sameCnt += 1;
                }

                L[j] = Math.max(L[j], sameCnt); 
            }
        }

        for(int i = 1; i <= 3; i++){
            int sameCnt = 0;

            for(int j = n-1; j >= 0; j--){
                if(B[j] == i) {
                    sameCnt += 1;
                }

                R[j] = Math.max(R[j], sameCnt); 
            }
        }

        // 해당 순간에 선택을 변경했다 했을 때
        // 최대로 이기는 횟수를 갱신해줍니다.
        for(int i = 0; i < n - 1; i++)
            ans = Math.max(ans, L[i] + R[i + 1]);

        System.out.print(ans);

    }
}