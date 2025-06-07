import java.util.*;
import java.io.*;

class Point {
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

}
public class Main {
    public static final int MAX_NUM = 1000000;

    public static int n;
    public static int[][] board;
    public static boolean[][] visited;

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return ( 1 <= x && x <= n && 1 <= y && y <= n );
    }

    public static boolean canGo(int x, int y, int nx, int ny, int D) {
        if(!inRange(nx, ny))
            return false;

        if(visited[nx][ny])
            return false;

        if(Math.abs(board[nx][ny] - board[x][y]) > D)
            return false;

        
        return true;
    }

    public static void BFS(int mid) {
        Queue<Point> q = new LinkedList<>();
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(board[i][j] == 0)
                    q.add(new Point(i, j));
            }
        }

        while(!q.isEmpty()) {
            Point curr = q.poll();
            int x, y;
            
            x = curr.x;
            y = curr.y;
            visited[x][y] = true;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(x, y, nx, ny, mid)){
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static boolean isPossible(int mid) {
        visited = new boolean[n+1][n+1];
        BFS(mid);
    
        int cnt = 0;
        int minValue;
        
        if(n % 2 == 0)
            minValue = (n * n) / 2;
        else
            minValue = (n * n) / 2 + 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(visited[i][j])
                    cnt++;
            }
        }

        return cnt >= minValue;
        
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

        int left = 0;
        int right = MAX_NUM;
        int ans = MAX_NUM;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
            else {
                left = mid + 1;
            }
        }

        System.out.print(ans);

    }
}