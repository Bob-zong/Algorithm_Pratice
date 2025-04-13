import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // 1번 개발자가 2 ~ 3~ n번 개발자보다 순위가 높은 경우를 찾아
        int[][] answer = new int[n+1][k];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int Num = Integer.parseInt(st.nextToken());
                answer[Num][i] = j+1;
            }
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= n; j++){
                if(i == j)
                    continue;
                boolean condition = true;
                for(int l = 0; l < k; l++){
                    if(answer[i][l] > answer[j][l])
                        condition = false;
                }
                if(condition)
                    cnt += 1;
            }
            
        }    

        System.out.print(cnt);
    }
}