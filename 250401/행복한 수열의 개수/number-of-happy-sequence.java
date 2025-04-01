import java.util.*;
import java.io.*;

public class Main {
    public static final int MAXNUM = 100;

    public static int n, m;

    public static int[][] answer = new int[MAXNUM][MAXNUM];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //각 행 or 열에 대해서 1차원 배열로 생각해서 행복한 수를 세보자
        // 각행을 탐색 2n * 2n N^2

        int ans = 0;

        for(int i = 0; i < n; i++){
            boolean happy = false;
            int cnt = 1;
            for(int j = 1; j < n; j++){
                if(answer[i][j-1] == answer[i][j])
                    cnt += 1;
                else{
                    cnt = 1;
                }

                if(cnt >= m){
                    // System.out.printf("행 성공! x: %d y: %d \n", i,j);
                    happy = true;
                    break;
                }
            }

            if(happy)
                ans += 1;
        }

        for(int i = 0; i < n; i++){
            boolean happy = false;
            int cnt = 1;
            for(int j = 1; j < n; j++){
                if(answer[j-1][i] == answer[j][i])
                    cnt += 1;
                else{
                    cnt = 1;
                }

                if(cnt >= m){
                    // System.out.printf("열 성공! x: %d y: %d \n", i,j);
                    happy = true;
                    break;
                }
            }

            if(happy)
                ans += 1;
        }

        System.out.print(ans);

        
    }
}