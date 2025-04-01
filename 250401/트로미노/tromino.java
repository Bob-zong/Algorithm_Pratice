import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[][] answer;
    
    public static int getMaxblock1() {
        int max = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m-1; j++){
                int sum = answer[i][j] + answer[i+1][j] + answer[i][j+1] + answer[i+1][j+1];

                for(int x = 0; x < 2; x++){
                    for(int y = 0; y < 2; y++){
                        int val = sum - answer[x][y];
                        max = Math.max(max, val);
                    }
                } 
            }
        }
        return max;
    }

    public static int getMaxblock2() {
        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m - 2; j++){
                int sum = 0;
                for(int k = j; k < j + 3; k++){
                    sum += answer[i][k];
                }
                max = Math.max(sum, max);
            }
        }

        for(int j = 0; j < m; j++){
            for(int i = 0; i < n - 2; i++){
                int sum = 0;
                for(int k = i; k < i + 3; k++){
                    sum += answer[k][j];
                }
                max = Math.max(sum, max);
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1 x 3 짜리 블럭 탐색 n * m * 3 3nm
        // ㄴ 모양 블럭 탐색 n * m * 4
        // O(nm)

        int ans1 = getMaxblock1();
        int ans2 = getMaxblock2();
        // System.out.print(ans1 + " " + ans2);
        int ans = Math.max(ans1, ans2);

        System.out.print(ans);
    }
}