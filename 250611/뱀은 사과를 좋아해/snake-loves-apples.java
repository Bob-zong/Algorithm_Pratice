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
    public static int n, m, k;// 격자 크기, 사과 개수, 방향 변환 횟수

    public static int[][] board;
    public static boolean[][] status;
    public static int ans;

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static int currX, currY;
    
    // public static HashSet<Point> s = new HashSet<>();
    
    public static Deque<Point> deq = new ArrayDeque<>();

    public static int getDirNum(char dir) {
        if(dir == 'U')
            return 0;
        else if(dir == 'R')
            return 1;
        else if(dir == 'D')
            return 2;
        else
            return 3;
    }

    public static boolean inRange(int x, int y) {
        return (1<= x && x <= n & 1 <= y && y <= n);
    }

    public static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny)) return false;

        Point tail = deq.peekLast(); // 현재 꼬리 위치
        if (status[nx][ny] && !(tail.x == nx && tail.y == ny)) return false;

        return true;
    }

    public static int move(char dir, int dist) {
    int dirNum = getDirNum(dir);

    for (int i = 0; i < dist; i++) {
        int nx = currX + dx[dirNum];
        int ny = currY + dy[dirNum];
         ans++; // 여기서 시간 증가
        if (!canGo(nx, ny)) 
            return -1;  // ❗ 충돌 발생

        // 이동
        currX = nx;
        currY = ny;

        deq.addFirst(new Point(nx, ny));
        status[nx][ny] = true;

        if (board[nx][ny] == 1) {
            board[nx][ny] = 0;
        } else {
            Point tail = deq.pollLast();
            status[tail.x][tail.y] = false;
        }

       
    }

    return 0;  // 정상 수행 완료
}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];
        status = new boolean[n+1][n+1];

        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int x, y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            board[x][y] = 1;
        }
        
        currX = 1;
        currY = 1;
        deq.add(new Point(currX, currY));
        status[currX][currY] = true;

        ans = 0;

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            int dist = Integer.parseInt(st.nextToken());

            int result = move(dir, dist);
            if (result == -1) break;  // 
        }

        System.out.print(ans);

        
    }
}