import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[][] answer;
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0 , -1 ,0};

    public static boolean inRange(int x, int y){
        return ( 0 <= x && x < n && 0 <= y && y < m);
    }

    public static void simulate(int x, int y){
        int dir_num = 0;

        answer[x][y] = 1;

        for(int i = 2; i <= n * m; i++){
                int nx = x + dx[dir_num];
                int ny = y + dy[dir_num];
                if(!inRange(nx, ny) || answer[nx][ny] != 0){
                    dir_num = (dir_num + 1) % 4;
                }
                x = x + dx[dir_num];
                y = y + dy[dir_num];

                answer[x][y] = i;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n][m];

        simulate(0, 0);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}