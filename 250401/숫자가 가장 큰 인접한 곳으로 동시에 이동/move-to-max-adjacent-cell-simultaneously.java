import java.util.*;
import java.io.*;

class Pair {
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 20;

    public static int n , m , t;

    public static int[][] answer = new int[MAX_N+1][MAX_N+1];
    public static int[][] count = new int[MAX_N+1][MAX_N+1];
    public static int[][] nextCount = new int[MAX_N+1][MAX_N+1];

    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1 ,1};

     public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    public static void simulate(){
        // 모든 구슬을 한 번씩 움직인다.
        moveAll();

        // 모두 움직인 이후에 충돌이 일어난 구슬을 삭제
        removeDuplicateMarbles();
    }
    
    public static void removeDuplicateMarbles(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(count[i][j] >= 2){
                    count[i][j] = 0;
                }
            }
        }
    }
    public static void moveAll(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                nextCount[i][j] = 0;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(count[i][j] == 1)
                    move(i, j);
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                count[i][j] = nextCount[i][j];
            }
        }
    }

    public static void move(int x, int y){
        // 4방향 중 가장 큰 값을 찾는다.
        Pair nextPos = getMax(x, y);
        int nextX = nextPos.x, nextY = nextPos.y;

        nextCount[nextX][nextY] += 1;
    }

    public static Pair getMax(int x, int y){
        int maxNum = 0;
        Pair maxPos = new Pair(-1, -1);

        for(int i = 0; i < DIR_NUM; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx, ny) && answer[nx][ny] > maxNum){
                maxNum = answer[nx][ny];
                maxPos = new Pair(nx, ny);
            }
        }

        return maxPos;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            count[x][y] = 1;
        }

        while(t-- > 0){
            simulate();
        }

        int ans = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                ans += count[i][j];        
            }
        }

        System.out.print(ans);

    }
}

// 각 칸을 돌면서 구슬의 위치를 확인 N2 * 4
//