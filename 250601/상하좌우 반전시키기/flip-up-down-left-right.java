import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static int cnt;

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return ( 1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static void reverse(int x, int y){
        // 현재 칸 반전
        board[x][y] ^= 1;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx, ny)){
                board[nx][ny] ^= 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        board = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(board[i-1][j] == 0){
                    reverse(i, j);
                    cnt++;
                }
            }
        }

        boolean condition = true;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(board[i][j] == 0){
                    condition = false;
                    break;
                }
            }
        }

        if(!condition)
            cnt = -1;
        
        System.out.print(cnt);
            
        
    }
}