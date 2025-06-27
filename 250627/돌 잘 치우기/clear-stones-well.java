import java.util.*;
import java.io.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

// public class Main {
//     public static int n, k, m;
//     public static int ans;

//     public static int[][] board;
//     public static boolean[][] visited;

//     public static Point[] startPos;
    
//     public static int[] dx = new int[]{-1, 0, 1, 0};
//     public static int[] dy = new int[]{0, 1, 0, -1};
//     public static Queue<Point> q = new LinkedList<>();
    
    
//     public static boolean inRange(int x, int y) {
//         return (1 <= x && x <= n && 1 <= y && y <= n);
//     }

//     public static boolean canGo(int x, int y) {
//         if(!inRange(x, y))
//             return false;
        
//         if(board[x][y] == 1)
//             return false;

//         return true;

//     }
//     public static void BFS(int startX, int startY) {
//         q.add(new Point(startX, startY));
//         int cnt = 0;

//         while(!q.isEmpty()) {
//             Point curr = q.poll();
//             int x, y;
//             x = curr.x;
//             y = curr.y;

//             for(int i = 0; i < 4; i++) {
//                 int nx = x + dx[i];
//                 int ny = y + dy[i];

//                 if(canGo(nx , ny)) {
//                     ans++;
//                     visited[nx][ny] = true;
//                     q.add(new Point(nx, ny));
//                 }
//                 else if(inRange(nx, ny) && (cnt < m && board[nx][ny] == 1)){
//                     cnt += 1;
//                     visited[nx][ny] = true;
//                     q.add(new Point(nx, ny));
//                 }
//             }
//         }
//     }
    
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         n = Integer.parseInt(st.nextToken());
//         k = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());
//         ans = 0;

//         board = new int[n+1][n+1];
//         startPos = new Point[k];

//         for(int i = 1; i <= n; i++) {
//             st = new StringTokenizer(br.readLine());

//             for(int j = 1; j <= n; j++){
//                 board[i][j] = Integer.parseInt(st.nextToken());
//             }
//         }

//         for(int i = 0; i < k; i++){
//             st = new StringTokenizer(br.readLine());

//             int x, y;
//             x = Integer.parseInt(st.nextToken());
//             y = Integer.parseInt(st.nextToken());

//             startPos[i] = new Point(x, y);
//         }

//         for(int i = 0; i < k; i++){
//             int x, y;
//             x = startPos[i].x;
//             y = startPos[i].y;

//             BFS(x, y);
//         }

//         System.out.print(ans);
//     }
// }

public class Main {
    public static int n, k, m;
    public static int maxVisited;

    public static int[][] board;
    public static boolean[][] visited;

    public static Point[] startPos;
    public static ArrayList<Point> walls = new ArrayList<>();

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return (1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && !visited[x][y] && board[x][y] == 0;
    }

    public static int BFS() {
        visited = new boolean[n+1][n+1];
        Queue<Point> q = new LinkedList<>();
        int cnt = 0;

        for(Point p : startPos){
            q.add(p);
            if (!visited[p.x][p.y]) {
                visited[p.x][p.y] = true;
                cnt++;
            }
        }

        while(!q.isEmpty()) {
            Point curr = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                    cnt++;
                }
            }
        }

        return cnt;
    }

    // 조합으로 m개의 벽 제거
    public static void chooseWalls(int idx, int count, List<Point> chosen) {
        if(count == m) {
            // 벽 제거
            for(Point p : chosen) {
                board[p.x][p.y] = 0;
            }

            // BFS로 탐색
            int result = BFS();
            maxVisited = Math.max(maxVisited, result);

            // 원복
            for(Point p : chosen) {
                board[p.x][p.y] = 1;
            }
            return;
        }

        if(idx == walls.size()) return;

        // 현재 벽 포함
        chosen.add(walls.get(idx));
        chooseWalls(idx + 1, count + 1, chosen);
        chosen.remove(chosen.size() - 1);

        // 현재 벽 미포함
        chooseWalls(idx + 1, count, chosen);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];
        startPos = new Point[k];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1)
                    walls.add(new Point(i, j)); // 벽 위치 저장
            }
        }

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            startPos[i] = new Point(x, y);
        }

        maxVisited = 0;
        chooseWalls(0, 0, new ArrayList<>());

        System.out.println(maxVisited);
    }
}
