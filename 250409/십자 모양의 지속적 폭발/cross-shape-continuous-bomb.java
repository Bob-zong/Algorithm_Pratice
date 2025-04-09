import java.util.*;
import java.io.*;

public class Main {
    // 1. 입력 받은 열에서 가장 위에 있는 값 찾기 N
    // 2. 해당 열의 값 만큼 4방향 0으로 만들기 for 4 * 열의 크기
    // 3. temp 배열에 아래에서 부터 값 복사 n^2
    // 4. m * n ^ 2

    public static int n, m;
    public static int[][] answer;
    public static int[][] temp;

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y){
        return ( 1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static void simulate(int col) {
        int highestRow = 1;
        for(int i = 1; i <= n; i++){
            if(answer[i][col] != 0) {
                highestRow = i;
                break;
            }
        }

        int bombScale = answer[highestRow][col];
        // 폭탄을 터치는 함수 
        for(int dir = 0; dir < 4; dir++){
            for(int i = 0; i < bombScale; i++){
                int nx = highestRow + dx[dir] * i;
                int ny = col + dy[dir] * i;
                
                if(inRange(nx, ny)){
                    answer[nx][ny] = 0;
                }
            }
        }

        moveBomb();
    }
    // 폭탄을 떨어뜨리는 함수
    public static void moveBomb() {
        temp = new int[n+1][n+1];
        
        for(int col = 1; col <= n; col++){
            int endRowIdx = n;

            for(int row = n; row >= 1; row--){
                if(answer[row][col] != 0)
                    temp[endRowIdx--][col] = answer[row][col];
            }
        }

        copyArray();
    }

    public static void copyArray() {
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                answer[i][j] = temp[i][j];
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++){
            int col = Integer.parseInt(br.readLine());

            simulate(col);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}