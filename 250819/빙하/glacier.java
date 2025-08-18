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
    public static final int MAX_M = 200;
    public static final int MAX_N = 200;
    public static final int DIR_NUM = 4;

    public static final int WATER = 0;
    public static final int GLACIER = 1;

    public static int n, m;
    
    public static int[][] board;
    public static boolean[][] visited;

    public static int cnt;

    public static int elapsedTime, lastMeltCnt;

    public static Queue<Pair> q = new LinkedList<>();

    public static void BFS() {
        initialize();

        q.add(new Pair(1, 1));
        visited[1][1] = true;

        while(!q.isEmpty()) {
            Pair currPos = q.poll();

            int x = currPos.x, y = currPos.y;

            for(int dir = 0; dir < DIR_NUM; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];

                if(canGo(nx, ny)) {
                    q.add(new Pair(nx , ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static boolean outsideWaterExistInNeighbor(int x, int y) {
        for(int dir = 0; dir < DIR_NUM; dir++) {
            int nx = x + dx[dir], ny = y + dy[dir];
            if(inRange(nx, ny) && visited[nx][ny])
                return true;
        }
    
        return false;
    }

    public static void melt() {
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                if(board[i][j] == GLACIER && 
                   outsideWaterExistInNeighbor(i, j)) {
                    board[i][j] = WATER;
                    lastMeltCnt++;
                }
    }

    // 빙하가 아직 남아있는지 확인합니다.
    public static boolean glacierExist() {
        for(int i = 1; i <= n; i++)
            for(int j = 0; j <= m; j++)
                if(board[i][j] == GLACIER)
                    return true;
    
        return false;
    }


    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return ( 1 <= x && x <= n && 1 <= y && y <= m );
    }
    
    public static boolean canGo(int x, int y) {
        return inRange(x, y) && board[x][y] == WATER && !visited[x][y];
    }

    public static void initialize() {
        for(int i = 1; i <= n; i++)
            for(int j = 0; j <= m; j++)
                visited[i][j] = false;
    }
    // 빙하를 한 번 녹입니다.
    public static void simulate() {
        elapsedTime++;
        lastMeltCnt = 0;
    
        // 빙하에 둘러쌓여 있지 않은 물의 위치를 전부 
        // visited로 체크합니다.
        BFS();
    
        // 인접한 영역에 빙하에 둘러쌓여 있지 않은 물이 있는 빙하를 찾아
        // 녹여줍니다.
        melt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        do {
            // 빙하를 한 번 녹입니다. 
            simulate();
        } while(glacierExist()); // 빙하가 존재하는 한 계속 반복합니다.

        // 출력:
        System.out.print(elapsedTime + " " + lastMeltCnt);
    }
}