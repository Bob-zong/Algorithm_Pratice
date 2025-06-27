// import java.util.*;
// import java.io.*;

// class Pair {
//     int x, y;

//     public Pair(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }
// }

// public class Main {
//     public static int n, k, u, d;
//     public static int[][] board;
//     public static boolean[][] visited;
//     public static int ans;
//     public static ArrayList<Pair> sPos = new ArrayList<>();
//     public static ArrayList<Pair> pos = new ArrayList<>();

//     public static Queue<Pair> q = new LinkedList<>();

//     public static int[] dx = new int[]{-1, 0, 1, 0};
//     public static int[] dy = new int[]{0, 1, 0, -1};

//     public static boolean inRange(int x, int y) {
//         return (1 <= x && x <= n && 1 <= y && y <= n);
//     } 

//     public static boolean canGo(int x, int y, int nx, int ny) {
//         if(!inRange(nx, ny))
//             return false;
        
//         int diff = Math.abs(board[nx][ny] - board[x][y]);
        
//         if(!(diff >= u && diff <= d))
//             return false;

//         return true;

//     }

//     public static void findMax(int idx, int cnt) {
//         if(cnt > k) 
//             return;

//         if(idx == n * n) {
//             if(cnt == k)
//                 ans = Math.max(ans, calc());
//             return;
//         }

//         sPos.add(pos.get(idx));
//         findMax(idx + 1, cnt + 1);
//         sPos.remove(sPos.size() - 1);
        
//         findMax(idx + 1, cnt);

//     }

//     public static int calc() {
//         int cnt = 0;

//         for(int i = 1; i <= n; i++) {
//             for(int j = 1; j <= n; j++) {
//                 visited[i][j] = false;
//             }
//         }

//         BFS();

//         for(int i = 1; i <= n; i++){
//             for(int j = 1; j <= n; j++) {
//                 if(visited[i][j])
//                     cnt++;
//             }
//         }

//         return cnt;
//     }

//     public static void BFS() {
//         q.clear(); // BFS() 시작 시 호출 필수

//         for(int i = 0; i < (int) sPos.size(); i++) {
//             q.add(sPos.get(i));
//         }

//         while(!q.isEmpty()) {
//             Pair curr = q.poll();

//             int x, y;
//             x = curr.x;
//             y = curr.y;

//             for(int i = 0; i < 4; i++) {
//                 int nx, ny;

//                 nx = x + dx[i];
//                 ny = y + dy[i];

//                 if(canGo(x, y, nx, ny)) {
//                     q.add(new Pair(nx, ny));
//                     visited[nx][ny] = true;
//                 }
//             }
//         }
//     }
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         n = Integer.parseInt(st.nextToken());
//         k = Integer.parseInt(st.nextToken());
//         u = Integer.parseInt(st.nextToken());
//         d = Integer.parseInt(st.nextToken());

//         board = new int[n+1][n+1];
//         visited = new boolean[n+1][n+1];

//         for(int i = 1; i <= n; i++) {
//             st = new StringTokenizer(br.readLine());

//             for(int j = 1; j <= n; j++) {
//                 board[i][j] = Integer.parseInt(st.nextToken());
//                 pos.add(new Pair(i, j));
//             }
//         }


//         findMax(0, 0);

//         System.out.print(ans);
//     }
// }


import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, k, u, d;
    public static int[][] board;
    public static boolean[][] visited;
    public static int ans = 0;

    public static ArrayList<Pair> pos = new ArrayList<>();
    public static ArrayList<Pair> selected = new ArrayList<>();

    public static Queue<Pair> q = new LinkedList<>();

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    public static boolean canMove(int fromX, int fromY, int toX, int toY) {
        if (!inRange(toX, toY) || visited[toX][toY])
            return false;

        int diff = Math.abs(board[toX][toY] - board[fromX][fromY]);
        return u <= diff && diff <= d;
    }

    public static void bfs() {
        q.clear();
        visited = new boolean[n + 1][n + 1];

        for (Pair p : selected) {
            q.add(p);
            visited[p.x][p.y] = true;
        }

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (canMove(x, y, nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }

    public static int countVisited() {
        int cnt = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (visited[i][j])
                    cnt++;
        return cnt;
    }

    public static void choose(int idx, int cnt) {
        if (cnt == k) {
            bfs();
            ans = Math.max(ans, countVisited());
            return;
        }

        if (idx == pos.size()) return;

        selected.add(pos.get(idx));
        choose(idx + 1, cnt + 1);
        selected.remove(selected.size() - 1);

        choose(idx + 1, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                pos.add(new Pair(i, j));
            }
        }

        choose(0, 0);
        System.out.println(ans);
    }
}
