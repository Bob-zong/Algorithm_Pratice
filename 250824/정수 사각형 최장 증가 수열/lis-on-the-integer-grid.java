import java.util.*;
import java.io.*;

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 500;
    
    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] dp = new int[MAX_N][MAX_N];

    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static int findMax(int x, int y) {
        // Memozation 활용
        
        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        int best = 1;

        for(int j = 0; j < DIR_NUM; j++) {
            int nx = x + dx[j], ny = y + dy[j];
            
            if(inRange(nx, ny) && grid[nx][ny] > grid[x][y]){
                best = Math.max(best, findMax(nx, ny) + 1);
            }
        }

        return dp[x][y] = best;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n ; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, findMax(i, j));
            }
        }

        System.out.print(ans);

    }
}
// class Pair implements Comparable<Pair> {
//     int num, x, y;

//     public Pair(int num, int x, int y) {
//         this.num = num;
//         this.x = x;
//         this.y = y;
//     }

//     @Override
//     public int compareTo(Pair p) {
//         return this.num - p.num;
//     }
// }

// public class Main {
//     public static int n;
//     public static int[][] board;
//     public static int[][] dp;

//     public static int answer;
//     public static ArrayList<Pair> cells = new ArrayList<>();

//     public static int[] dx = new int[]{-1, 0, 1, 0};
//     public static int[] dy = new int[]{0, 1, 0, -1};

//     public static boolean inRange(int x, int y) {
//         return ( 1 <= x && x <= n && 1 <= y && y <= n);
//     }


//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;

//         n = Integer.parseInt(br.readLine());
        
//         answer = 0;

//         board = new int[n+1][n+1];
//         dp = new int[n+1][n+1];
        
//         for(int i = 1; i <= n; i++) {
//             st = new StringTokenizer(br.readLine());

//             for(int j = 1; j <= n; j++) {
//                 board[i][j] = Integer.parseInt(st.nextToken());
//                 cells.add(new Pair(board[i][j], i, j));
//             }
//         }
//          // 오름차순으로 정렬을 진행합니다.
//         Collections.sort(cells);

//         for(int i = 1; i <= n; i++)
//             for(int j = 1; j <= n; j++)
//                 dp[i][j] = 1;
        

//         for(int i = 0; i < cells.size(); i++) {
//             int x = cells.get(i).x;
//             int y = cells.get(i).y;

//             for(int j = 0; j < 4; j++) {
//                 int nx = x + dx[j], ny = y + dy[j];

//                 if(inRange(nx, ny) && board[nx][ny] > board[x][y]){
//                     dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
//                 }
//             }
//         }

//         for(int i = 1; i <= n; i++)
//             for(int j = 1; j <= n; j++)
//                 answer = Math.max(answer, dp[i][j]);

//         System.out.print(answer);
//     }
// }