import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        
        int[][] answer = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int maxCnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-2; j++){
                for(int k = 0; k < n; k++){
                    for(int l = 0; l < n-2; l++){
                        if(i == k && (Math.abs(l - j)) <=2)
                            continue;
                        int cnt = 
                        answer[i][j] + answer[i][j+1] + answer[i][j+2] +
                        answer[k][l] + answer[k][l+1] + answer[k][l+2];
                        maxCnt = Math.max(maxCnt, cnt);
                    }
                }
            }
        }
        System.out.print(maxCnt);
    }
}