import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair> {
    int num, x, y;

    public Pair(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        return this.num - p.num;
    }
}

public class Main {
    public static int n;
    public static int[][] board;
    public static int[][] dp;

    public static int answer;
    public static ArrayList<Pair> cells = new ArrayList<>();

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return ( 1 <= x && x <= n && 1 <= y && y <= n);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        
        answer = 0;

        board = new int[n+1][n+1];
        dp = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                cells.add(new Pair(board[i][j], i, j));
            }
        }
         // 오름차순으로 정렬을 진행합니다.
        Collections.sort(cells);

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                dp[i][j] = 1;
        

        for(int i = 0; i < cells.size(); i++) {
            int x = cells.get(i).x;
            int y = cells.get(i).y;

            for(int j = 0; j < 4; j++) {
                int nx = x + dx[j], ny = y + dy[j];

                if(inRange(nx, ny) && board[nx][ny] > board[x][y]){
                    dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
                }
            }
        }

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                answer = Math.max(answer, dp[i][j]);

        System.out.print(answer);
    }
}