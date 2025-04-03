import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] answer;
    public static int[][] temp;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static int targetX, targetY;

    public static boolean inRange(int x, int y){
        return ( 1 <= x && x <= n && 1 <= y && y <= n);
    }
    
    public static void Boom(int row, int col) {
        int scale = answer[row][col];

        for(int i = 0; i < scale; i++){

            for(int j = 0; j < 4; j++){
                int nx = row + i * dx[j];
                int ny = col + i * dy[j];

                if(inRange(nx, ny))
                    answer[nx][ny] = 0;
            }
        }

        for(int j = 1; j <= n; j++){
            int endRow = n;
            for(int i = n; i >= 1; i--){
                if(answer[i][j] != 0){
                    temp[endRow--][j] = answer[i][j];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        answer = new int[n+1][n+1];
        temp = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        targetX = Integer.parseInt(st.nextToken());
        targetY = Integer.parseInt(st.nextToken());

        // 폭탄이 터지는 곳에 값 만큼 포문 4방향으로 포문 돌리기 4 * n 0으로 채우기
        // temp 배열 하나 똑같이 만들어서 값이 0이 아니면 값을 추가해
        // 다시 복사

        Boom(targetX, targetY);

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sb.append(temp[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}