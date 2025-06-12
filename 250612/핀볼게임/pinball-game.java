import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static int ans = 0;

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static int changeDir(int dir, int type) {
        if(type == 1){ // /
            if(dir == 0) return 3; // 상 → 우
            if(dir == 1) return 2; // 우 → 상
            if(dir == 2) return 1; // 하 → 좌
            if(dir == 3) return 0; // 좌 → 하
        } else if(type == 2){ // \
            if(dir == 0) return 1; // 상 → 좌
            if(dir == 1) return 0; // 우 → 하
            if(dir == 2) return 3; // 하 → 우
            if(dir == 3) return 2; // 좌 → 상
        }
        return -1; // 예외 상황
    }
    public static boolean inRange(int x, int y) {
        return (1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static int move(int row, int col, int dir) {
    int cnt = 1;
    int x = row;
    int y = col;
    int currDir = dir;

    if (board[x][y] != 0)
        currDir = changeDir(dir, board[x][y]);

    while (true) {
        int nx = x + dx[currDir];
        int ny = y + dy[currDir];

        if (!inRange(nx, ny)) {
            cnt++; // 마지막 경계 벗어나는 것도 1칸으로 카운트
            break;
        }

        x = nx;
        y = ny;
        cnt++;

        if (board[x][y] != 0) {
            currDir = changeDir(currDir, board[x][y]);
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