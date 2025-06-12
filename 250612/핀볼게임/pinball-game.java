import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static int ans = 0;

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static int changeDir(int dir, int type) {
        int result = -1;

        if(type == 1){ // /
            if(dir == 2){ // 하
                // 좌
                result = 3;
            }
            else if(dir == 0){ // 상
                // 우
                result = 1;
            }
            else if(dir == 1){ // 우
                // 상
                result = 0;
            }
            else if(dir == 3){ // 좌
                // 하
                result = 2;
            }
        }
        else if(type == 2){ // \
            if(dir == 2){ // 하
                // 우
                result = 1;
            }
            else if(dir == 0){ // 상
                // 좌
                result = 3;
            }
            else if(dir == 1){ // 우
                // 하
                result = 2;
            }
            else if(dir == 3){ // 좌
                // 상
                result = 0;
            }
        }

        return result;
    }
    public static boolean inRange(int x, int y) {
        return (1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static int move(int row, int col, int dir) {
        int cnt = 1;
        int x = row;
        int y = col;
        int currDir = dir;

        while(inRange(x, y)) {
            int nx = x + dx[currDir];
            int ny = y + dy[currDir];
            cnt++;

            if(inRange(nx, ny)) {
                x = nx;
                y = ny;

                if(board[nx][ny] != 0) {
                    currDir = changeDir(currDir, board[nx][ny]);
                }

            }
            else{
                return cnt;
            }
        }

        return cnt;
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        board = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= n; i++) {
            ans = Math.max(ans, move(1, i, 2));
            ans = Math.max(ans, move(n, i, 0));
            ans = Math.max(ans, move(i, 1, 1));
            ans = Math.max(ans, move(i, n, 3));
        }

        System.out.print(ans);
        
    }
}