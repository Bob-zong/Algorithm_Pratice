import java.util.*;
import java.io.*;

public class Main {
    // r1 c1 ~ r2 c2 까지 shift 구현 -> n * m
    // 4 * n * m * q q번 만큼 평균 구하기 + shift  -> 백만

    public static int n, m, q;
    public static int[][] answer;
    public static int[][] temp;

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y){
        return ( 1 <= x && x <= n && 1 <= y && y <= m);
    }

    public static void rotate(int r1, int c1, int r2, int c2) {
        int[][] copy = new int[n+1][m+1];
        
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                copy[i][j] = answer[i][j];

        for (int i = c1 + 1; i <= c2; i++)
            answer[r1][i] = copy[r1][i - 1];

        for (int i = r1 + 1; i <= r2; i++)
            answer[i][c2] = copy[i - 1][c2];

        for (int i = c2 - 1; i >= c1; i--)
            answer[r2][i] = copy[r2][i + 1];

        for (int i = r2 - 1; i >= r1; i--)
            answer[i][c1] = copy[i + 1][c1];
    }

    public static void simulate(int r1, int c1, int r2, int c2) {
        //각 행과 열에 대해서 shift 진행
        // 시계방향으로 회전 시키려면 반시계 방향 순서대로 값을 덮으면 됨
        // for(int i = c2; i > c1; i--){
        //     answer[r1][i] = answer[r1][i-1];
        // }

        // for(int i = r1; i < r2; i++){
        //     answer[i][c1] = answer[i+1][c1];
        // }

        // for(int i = c1; i < c2; i++){
        //     answer[r2][i] = answer[r2][i+1];
        // }

        // for(int i = r2; i > r1; i--){
        //     answer[i][c2] = answer[i-1][c2];
        // }
        rotate(r1, c1, r2, c2);

        changeAverage(r1, c1, r2, c2);

    }
    
    public static void changeAverage(int r1, int c1, int r2, int c2) {
        for(int x = r1; x <= r2; x++){
            for(int y = c1; y <= c2; y++){
                int cnt = 1;
                int sum = answer[x][y];
                for(int dir = 0; dir < 4; dir++){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if(inRange(nx, ny)){
                        cnt += 1;
                        sum += answer[nx][ny];
                    }
                }
                temp[x][y] = sum / cnt;
            }
        }
        // 평균을 원본 배열에 복사

        for(int x = r1; x <= r2; x++){
            for(int y = c1; y <= c2; y++){
                answer[x][y] = temp[x][y];
            }
        }

        //temp 초기화
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                temp[i][j] = 0;
            }
        }
        
    } 
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken()); // 바람 횟수

        answer = new int[n+1][m+1];
        temp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            simulate(r1, c1, r2, c2);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        
    }
}