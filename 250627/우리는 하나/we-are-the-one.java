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

    public static int ans;

    public static ArrayList<Pair> sPos = new ArrayList<>();
    public static ArrayList<Pair> pos = new ArrayList<>();

    public static Queue<Pair> q = new LinkedList<>();

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return (1 <= x && x <= n && 1 <= y && y <= n);
    } 

    public static boolean canGo(int x, int y, int nx, int ny) {
        if(!inRange(nx, ny) || visited[nx][ny])
            return false;
        
        int diff = Math.abs(board[nx][ny] - board[x][y]);
        
        if(!(diff >= u && diff <= d))
            return false;

        return true;

    }

    public static void findMax(int idx, int cnt) {
        if(cnt > k) 
            return;

        if(idx == n * n) {
            if(cnt == k)
                ans = Math.max(ans, calc());
            return;
        }

        sPos.add(pos.get(idx));
        findMax(idx + 1, cnt + 1);
        sPos.remove(sPos.size() - 1);
        
        findMax(idx + 1, cnt);

    }

    public static int calc() {
        int cnt = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                visited[i][j] = false;
            }
        }

        for(int i = 0; i < k; i++) {
            q.add(sPos.get(i));
            visited[sPos.get(i).x][sPos.get(i).y] = true;
        }

        BFS();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++) {
                if(visited[i][j])
                    cnt++;
            }
        }

        return cnt;
    }

    public static void BFS() {

        while(!q.isEmpty()) {
            Pair curr = q.poll();

            int x, y;
            x = curr.x;
            y = curr.y;

            for(int i = 0; i < 4; i++) {
                int nx, ny;

                nx = x + dx[i];
                ny = y + dy[i];

                if(canGo(x, y, nx, ny)) {
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                pos.add(new Pair(i, j));
            }
        }


        findMax(0, 0);

        System.out.print(ans);
    }
}
