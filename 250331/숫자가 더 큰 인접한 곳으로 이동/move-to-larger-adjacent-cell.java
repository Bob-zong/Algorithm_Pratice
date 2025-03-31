import java.util.*;
import java.io.*;

class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n;
    public static int currX, currY; // 현재 위치를 의미합니다.
    public static int[][] grid;
    public static StringBuilder sb;
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static ArrayList<Integer> visitedNums = new ArrayList<>();
    // 범위가 격자 안에 들어가는지 확인합니다.
    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }
    public static boolean canGo(int x, int y, int currNum) {
        return inRange(x, y) && grid[x][y] > currNum;
    }
    public static boolean simulate() {
        for(int i = 0; i < 4; i++){
            int nx = currX + dx[i];
            int ny = currY + dy[i];
            
            if(canGo(nx, ny, grid[currX][currY])){
                currX = nx;
                currY = ny;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        currX = Integer.parseInt(st.nextToken());
        currY = Integer.parseInt(st.nextToken());
        grid = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visitedNums.add(grid[currX][currY]);
        while(true) {
            // 조건에 맞춰 움직여봅니다.
            boolean greaterNumberExist = simulate();

            // 인접한 곳에 더 큰 숫자가 없다면 종료합니다.
            if(!greaterNumberExist)
                break;
            
            // 움직이고 난 후의 위치를 답에 넣어줍니다.
            visitedNums.add(grid[currX][currY]);
        }

        for(int i = 0; i < visitedNums.size(); i++){
            sb.append(visitedNums.get(i)).append(" ");
        }
        System.out.print(sb);
    }
}