import java.util.*;
import java.io.*;
public class Main {
    public static int n, m;
    public static int[][] answer;

    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    
    public static boolean inRange(int x, int y){
        return ( 0 <= x && x < n && 0 <= y && y < m);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n][m];
        int currDir = 0;
        int x = 0, y = 0;
        answer[x][y] = 1;

        for(int i = 2; i <= n * m; i++){
            int nx , ny;
            nx = x + dx[currDir];
            ny = y + dy[currDir];
            if(!inRange(nx, ny) || answer[nx][ny] != 0){
                currDir = (currDir + 1) % 4;
            }

            x = x + dx[currDir];
            y = y + dy[currDir];
            answer[x][y] = i;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    
    }
}