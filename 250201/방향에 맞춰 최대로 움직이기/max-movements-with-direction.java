import java.util.*;
import java.io.*;

public class Main {
    // public static HashMap<Integer, Integer> map;
    public static int n;
    public static int startRow, startCol;
    public static int maxScore;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static int[][] answer;
    public static int[][] dirAns;

    public static int[] dx = new int[]{0, -1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = new int[]{0, 0, 1, 1, 1, 0, -1, -1, -1};
    
    public static boolean inRange(int x, int y){
        return ( 0 <= x && x < n && 0 <= y && y < n );
    }

    public static boolean canGo(int x, int y, int nx, int ny){
        return (answer[nx][ny] > answer[x][y]);
    }

    public static void findMax(int x, int y, int cnt){
        maxScore = Math.max(maxScore, cnt);
        int dir = dirAns[x][y];

        for(int i = 0; i < n; i++){
            int nx = x + dx[dir] * i, ny = y + dy[dir] * i;
            if(inRange(nx, ny) && canGo(x, y, nx, ny)){
                findMax(nx , ny, cnt+1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        answer = new int[n][n];
        dirAns = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        } 

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                dirAns[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startRow = Integer.parseInt(st.nextToken());
        startCol = Integer.parseInt(st.nextToken());

        findMax(startRow - 1, startCol - 1, 0);
        System.out.print(maxScore);

    }
}