import java.util.*;
import java.io.*;

public class Main {
    // 각 초마다 폭탄이 증식하는 상황 M 
    // 격자를 완탐해서 폭탄을 증식하는 곳에서 놔 -> N^2 * 4 * 
    // 시간이 끝나고 폭탄 세기 N ^ 2 -> N ^ 2 * m -> 100 * 100 * 8 * 4

    public static int n, t, row, col;
    public static int[][] answer;
    public static int[][] temp;

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    
    public static boolean inRange(int x, int y){
        return (1 <= x && x <= n && 1 <= y && y <= n);
    }
    public static void createBomb(int x, int y, int time){
        for(int i = 0; i < 4; i++){
            int nx = x + (dx[i] * (int)Math.pow(2, time-1));
            int ny = y + (dy[i] * (int)Math.pow(2, time-1));

            if(inRange(nx, ny) && answer[nx][ny] == 0){
                // System.out.println(nx + " " + ny);
                temp[nx][ny] = 1;
            }
        }
    }
    public static void simulate() {
        int time = 1;
        answer[row][col] = 1;

        while(time <= t){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    temp[i][j] = 0;
                }
            }

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(answer[i][j] == 1){
                        createBomb(i, j, time);
                    }
                }
            }

            // temp 배열을 answer로 복사하여 반영
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (temp[i][j] > 0) {
                        answer[i][j] = temp[i][j];
                    }
                }
            }

            time += 1;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        answer = new int[n+1][n+1];
        temp = new int[n+1][n+1];
        simulate();

        int cnt = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(answer[i][j] >= 1)
                    cnt += 1;
            }
        }

        System.out.print(cnt);
    }
}