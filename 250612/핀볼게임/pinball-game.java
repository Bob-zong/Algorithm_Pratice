import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static int ans = 0;

    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};

    public static int changeDir(int dir, int type) {
        int moveDir = dir;

        if(type == 1){ // /
            moveDir = 3 - moveDir;
        } else if(type == 2){ // \
            moveDir = (moveDir < 2) ? (moveDir + 2) : (moveDir - 2);
        }
        return moveDir; // 예외 상황
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
            if(board[x][y] != 0){
                currDir = changeDir(currDir, board[x][y]);
            }

            x = x + dx[currDir];
            y = y + dy[currDir];
            cnt++;            
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
            ans = Math.max(ans, move(n, i, 0));
            ans = Math.max(ans, move(1, i, 1));
            ans = Math.max(ans, move(i, n, 2));
            ans = Math.max(ans, move(i, 1, 3));

        }

        System.out.print(ans);
        
    }
}

