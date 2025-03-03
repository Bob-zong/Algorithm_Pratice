import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] answer;
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};

    public static boolean inRange(int x, int y){
        return ( 1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static int checkCnt(int x, int y){
        int cnt = 0;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny)){
                if(answer[nx][ny] == 1){
                    cnt += 1;
                }
                    
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        answer = new int[n+1][n+1];
       
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=n; j++){
                int num = checkCnt(i,j);
                if(num >= 3){
                    ans += 1;
                }
            }
        }
        // for(int i = 1; i <= n; i++){
        //     for(int j = 1; j <= n; j++){
        //         System.out.print(answer[i][j] + " ");
        //     }
        // }
        System.out.print(ans);
    }
}