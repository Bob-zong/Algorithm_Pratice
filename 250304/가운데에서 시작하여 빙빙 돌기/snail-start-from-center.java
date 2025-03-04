import java.util.*;
import java.io.*;
public class Main {
    public static int n;
    public static int[][] answer;

    public static int[] dx = new int[]{0, -1, 0, 1};
    public static int[] dy = new int[]{-1, 0, 1, 0};
    
    public static boolean inRange(int x, int y){
        return ( 0 <= x && x < n && 0 <= y && y < n);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        

        answer = new int[n][n];
        int currDir = 0;
        int x = n-1, y = n-1;
        int value = n * n;

        answer[x][y] = value;

        for(int i = 2; i <= n * n; i++){
            int nx , ny;
            nx = x + dx[currDir];
            ny = y + dy[currDir];
            if(!inRange(nx, ny) || answer[nx][ny] != 0){
                currDir = (currDir + 1) % 4;
            }

            x = x + dx[currDir];
            y = y + dy[currDir];
            answer[x][y] = --value;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    
    }
}
