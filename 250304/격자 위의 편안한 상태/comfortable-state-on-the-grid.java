import java.util.*;
import java.io.*;

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 100;
    
    public static int n, m;
    
    public static int[][] arr = new int[MAX_N+1][MAX_N+1];
    
    public static int[] dx = new int[]{0, 1,  0, -1};
    public static int[] dy = new int[]{1, 0, -1,  0};
    
    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }
    
    public static int checkStatus(int x, int y){
        int cnt = 0;

        for(int i = 0; i < DIR_NUM; i++){
            int nx, ny;
            nx = x + dx[i];
            ny = y + dy[i];
            if(inRange(nx, ny)){
                if(arr[nx][ny] == 1)
                    cnt += 1;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++){
            int row, col;
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            arr[row][col] = 1;

            if(checkStatus(row, col) == 3){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }

        }

        System.out.print(sb);
    }
}