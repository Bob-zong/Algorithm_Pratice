import java.util.*;
import java.io.*;

public class Main {
    // char 2차원 배열로 만들어서
    // L 위치를 찾고 -> 2만큼 가로 세로 대각선 방향을 다 확인해봐
    // n * m * 3 * 8  O(nm)
    public static int n, m;
    public static char[][] grid;
    public static int ans;

    public static int[] dx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    public static int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};

    public static boolean inRange(int x, int y) {
        return ( 0 <= x && x < n && 0 <= y && y < m);
    }

    public static void getWord(int x, int y){
        for(int dir = 0; dir < 8; dir++){
            int cnt = 0;
            for(int i = 1; i <= 2; i++){
                int nx = x + dx[dir] * i;
                int ny = y + dy[dir] * i;
                if(inRange(nx, ny)){
                    if(grid[nx][ny] == 'E')
                        cnt += 1;
                }
            }

            if(cnt == 2)
                ans += 1;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new char[n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                grid[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'L'){
                    getWord(i, j);
                }
            }
        }
        
        System.out.print(ans);
    }
}