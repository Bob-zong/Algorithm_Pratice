// import java.util.*;
// import java.io.*;

// class Pair{
//     public int x, y;
//     public Pair(int x, int y){
//         this.x = x;
//         this.y = y;
//     }
// }
// public class Main {
//     public static int n, k, max;
//     public static int maxXPos, maxYPos;
//     public static int startX, startY;
//     public static int[][] answer;
//     public static boolean[][] visited;
//     public static int[] dx = new int[]{1, 0, -1, 0};
//     public static int[] dy = new int[]{0, 1, 0, -1};
//     public static Queue<Pair> q = new LinkedList<>();
//     public static int maxNum = Integer.MIN_VALUE;
//     public static boolean inRange(int x, int y){
//         return ( 1 <= x && x <= n && 1 <= y && y <= n);
//     }
    
//     public static boolean canGo(int x, int y, int blockNum){
//         if(!inRange(x, y))
//             return false;
//         if(visited[x][y] == true || blockNum < answer[x][y])
//             return false;

//         return true;
//     }

//     public static void BFS() {
//     // int bfsMaxNum = Integer.MIN_VALUE; // max 값보다 작은 값 중에서 최대값을 저장할 변수
//     visited = new boolean[n+1][n+1];
//     q.add(new Pair(maxXPos, maxYPos));
//     visited[maxXPos][maxYPos] = true;

//     while (!q.isEmpty()) {
//         Pair curr = q.poll();
//         int x = curr.x, y = curr.y;

//         for (int i = 0; i < 4; i++) {
//             int nx = x + dx[i];
//             int ny = y + dy[i];

//             // max 값보다 작고 방문 가능한 경우
//             if (canGo(nx, ny, max)) {
//                 visited[nx][ny] = true;
//                 q.add(new Pair(nx, ny));

//                 if(answer[nx][ny] > maxNum){
//                     System.out.printf("nx: %d ny: %d \n", nx, ny);
//                     maxNum = answer[nx][ny];
//                     maxXPos = nx;
//                     maxYPos = ny;
//                 }
//                 else if(answer[nx][ny] == maxNum){
//                     if(maxXPos > nx){
//                         maxXPos = nx;
//                     }
//                     else if(maxXPos == nx){
//                         if(maxYPos > ny){
//                             maxYPos = ny;
//                         }
//                     }

//                 }
//             }
//         }
//     }
//     max = maxNum;
//     startX = maxXPos;
//     startY = maxYPos;
   
// }


//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         n = Integer.parseInt(st.nextToken());
//         k = Integer.parseInt(st.nextToken());

//         answer = new int[n+1][n+1];

//         for(int i = 1; i <= n; i++){
//             st = new StringTokenizer(br.readLine());
//             for(int j = 1; j <= n; j++){
//                 answer[i][j] = Integer.parseInt(st.nextToken());
//             }
//         }

//         st = new StringTokenizer(br.readLine());
//         startX = Integer.parseInt(st.nextToken());
//         startY = Integer.parseInt(st.nextToken());
        
//         maxXPos = startX;
//         maxYPos = startY;

//         max = answer[maxXPos][maxYPos];
        
//         for(int i = 0 ; i < k; i++){
//             BFS();
//         }
        
//         bw.write(String.valueOf(maxXPos) + " " + String.valueOf(maxYPos));
//         bw.flush();
//         bw.close();
//     }
// }

import java.util.*;
import java.io.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, k;
    static int[] ans = new int[2];
    static int[][] grid;
    static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        init();

        while (k-- > 0) {
            bfs();
        }

        System.out.printf("%d %d", ans[0] + 1, ans[1] + 1);
    }

    public static void bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        Pair maxNode = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        boolean[][] visitedBfs = new boolean[n][n];

        q.offer(new Pair(ans[0], ans[1]));
        visitedBfs[ans[0]][ans[1]] = true;
        int maxValue = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;

            if (maxValue < grid[x][y] && grid[ans[0]][ans[1]] > grid[x][y]) {
                maxValue = grid[x][y];
                maxNode.x = x;
                maxNode.y = y;
            } else if (maxValue == grid[x][y]) {
                if (maxNode.x > x) {
                    maxNode.x = x;
                    maxNode.y = y;
                } else if (maxNode.x == x && maxNode.y > y) {
                    maxNode.x = x;
                    maxNode.y = y;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];

                if (canGo(nx, ny) && !visitedBfs[nx][ny]) {
                    q.offer(new Pair(nx, ny));
                    visitedBfs[nx][ny] = true;
                }
            }
        }

        if (maxValue == Integer.MIN_VALUE) return;

        ans[0] = maxNode.x;
        ans[1] = maxNode.y;
    }

    public static boolean canGo(int nx, int ny) {
        return inRange(nx, ny) && grid[ans[0]][ans[1]] > grid[nx][ny];
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        ans[0] = Integer.parseInt(st.nextToken()) - 1;
        ans[1] = Integer.parseInt(st.nextToken()) - 1;
    }
}