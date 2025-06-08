import java.util.*;
import java.io.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Main {
    public static int n, m;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[][] startPos;
    public static int ans;

    public static Queue<Point> q;

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return (1 <= x && x <= m && 1 <= y && y <= n);
    }

    public static boolean canGo(int x, int y, int nx, int ny, int diff) {
        if(!inRange(nx, ny))
            return false;
        
        if(visited[nx][ny])
            return false;

        if(Math.abs(board[nx][ny] - board[x][y]) > diff)
            return false;

        return true;
    }
    public static void BFS(int diff) {
    visited = new boolean[m+1][n+1];
    q = new LinkedList<>();

    boolean foundStart = false;

    for (int i = 1; i <= m && !foundStart; i++) {
        for (int j = 1; j <= n; j++) {
            if (startPos[i][j] == 1) {
                q.add(new Point(i, j));
                visited[i][j] = true;
                foundStart = true;
                break;
            }
        }
    }

    while (!q.isEmpty()) {
        Point curr = q.poll();
        int x = curr.x;
        int y = curr.y;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(x, y, nx, ny, diff)) {
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
    }
}

    // public static void BFS(int diff) {
    //     visited = new boolean[m+1][n+1];
    //     q = new LinkedList<>();

    //     for(int i = 1; i <= m; i++){
    //         for(int j = 1; j <= n; j++){
    //             if(startPos[i][j] == 1)
    //                 q.add(new Point(i, j));
    //         }
    //     }

    //     while(!q.isEmpty()) {
    //         Point curr = q.poll();
    //         int x, y;
    //         x = curr.x;
    //         y = curr.y;
    //         visited[x][y] = true;
            
    //         for(int i = 0; i < 4; i++) {
    //             int nx = x + dx[i];
    //             int ny = y + dy[i];

    //             if(canGo(x, y, nx, ny, diff)){
    //                 visited[nx][ny] = true;
    //                 q.add(new Point(nx, ny));
                    
    //             }
    //         }
    //     }

    // }
    
    public static boolean isPossible() {
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++){
                if(startPos[i][j] == 1 && visited[i][j] == false)
                    return false;
            }
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[m+1][n+1];
        startPos = new int[m+1][n+1];

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++) {
                startPos[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int left = 0;
        int right = (int)1e9;
        ans = (int)1e9;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            BFS(mid);

            if(isPossible()){
                ans = Math.min(ans, mid);
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        System.out.print(ans);
    }
}