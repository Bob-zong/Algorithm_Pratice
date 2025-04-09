import java.util.*;
import java.io.*;

public class Main {
    // 폭탄을 터친다. -> O(4n)
    // 폭탄을 떨구는 작업 -> n ^ 2
    // 쌍이 몇개인지 확인하는 작업 -> n ^ 2;
    // 모든 행열에 대해서 작업 하니까 -> n ^ 2 (n ^ 2 + n ^ 2 + 4n) -> n ^ 4
    // n의 크기는 50 이니까 -> 625만 // 충분함

    public static int n;
    public static int[][] answer;
    public static int[][] temp;
    public static int[][] nextGrid;
    public static int maxPair;

    public static int[] dx = new int[] {-1, 0, 1, 0};
    public static int[] dy = new int[] {0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return ( 1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static void Bomb (int row, int col) {
        int bombScale = answer[row][col];
        
        temp[row][col] = 0;

        for(int dir = 0; dir < 4; dir++){
            for(int i = 1; i < bombScale; i++){
                int nx = row + dx[dir] * i;
                int ny = col + dy[dir] * i;

                if(inRange(nx, ny)) {
                    temp[nx][ny] = 0;
                }
            }
        }

    }

    public static void dropBomb() {

        for(int col = 1; col <= n; col++){
            int endIdx = n;

            for(int row = n; row >= 1; row--){
                if(temp[row][col] != 0){
                    nextGrid[endIdx--][col] = temp[row][col];
                }
            }
        }
    }

    public static int getPairCnt() {
        int cnt = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j < n; j++){
                if(nextGrid[i][j] == nextGrid[i][j+1] && nextGrid[i][j] != 0){
                    cnt += 1;
                    j = j+1;
                }
            }
        }

        for(int j = 1; j <= n; j++){
            for(int i = 1; i < n; i++){
                if(nextGrid[i][j] == nextGrid[i+1][j] && nextGrid[i][j] != 0){
                    cnt += 1;
                    i = i+1;
                }
            }
        }

        return cnt;
    }
    
    public static void initArray() {
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                temp[i][j] = answer[i][j];
                nextGrid[i][j] = 0;
            }
        }
    }
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        answer = new int[n+1][n+1];
        temp = new int[n+1][n+1];
        nextGrid = new int[n+1][n+1];

        maxPair = 0;

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initArray();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                Bomb(i, j);
                dropBomb();
                maxPair = Math.max(maxPair,getPairCnt());
                initArray();
            }
        }
        // Bomb(3, 3);
        // dropBomb();
        // maxPair = Math.max(maxPair,getPairCnt());

        System.out.print(maxPair);
    }
}