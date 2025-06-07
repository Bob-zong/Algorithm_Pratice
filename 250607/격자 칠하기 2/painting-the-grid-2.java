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

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    public static int BFS(int startX, int startY, int D) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));
        visited[startX][startY] = true;

        int size = 1;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            int x = curr.x;
            int y = curr.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (inRange(nx, ny) && !visited[nx][ny]
                    && Math.abs(board[nx][ny] - board[x][y]) <= D) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                    size++;
                }
            }
        }

        return size;
    }

    public static boolean isPossible(int D) {
        visited = new boolean[n + 1][n + 1];
        int maxAreaSize = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j]) {
                    int areaSize = BFS(i, j, D);
                    maxAreaSize = Math.max(maxAreaSize, areaSize);
                }
            }
        }

        int halfOrMore = (n * n + 1) / 2;  // 절반 이상
        return maxAreaSize >= halfOrMore;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int left = 0;
        int right = MAX_NUM;
        int ans = MAX_NUM;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(ans);
    }
}
