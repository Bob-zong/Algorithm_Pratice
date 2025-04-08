import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] answer;
    public static int m1, m2, m3, m4;
    public static int dir;
    public static int row, col;

    public static int[] dx = new int[]{-1, -1, 1, 1};
    public static int[] dy = new int[]{1, -1, -1, 1};

    public static void simulate() {
        int[] moveScale = new int[]{m1, m2, m3, m4};
        int scale = m1 + m2 + m3 + m4;
        int idx = 0;
        int[] rotate = new int[scale];
        // 1번 방향 시계 방향
        int x = row;
        int y = col;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < moveScale[i]; j++){
                x = x + dx[i];
                y = y + dy[i];

                rotate[idx++] = answer[x][y]; 
            }
        }
        // 2 3 4 2 3 1 -> 오른쪽 이동 반시계
        // 2 3 4 2 3 1 -> 왼쪽 이동
         
        if(dir == 0){
            int temp = rotate[idx-1];

            for(int i = idx-1; i > 0; i--){
                rotate[i] = rotate[i-1];
            }    
            
            rotate[0] = temp;
        }
        else{
            int temp = rotate[0];
            
            for(int i = 0; i < idx-1; i++){
                rotate[i] = rotate[i+1]; 
            }
            rotate[idx-1] = temp;
        }

        x = row;
        y = col;
        idx = 0;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < moveScale[i]; j++){
                x = x + dx[i];
                y = y + dy[i];

                answer[x][y] = rotate[idx++]; 
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        answer = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        m1 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
        m3 = Integer.parseInt(st.nextToken());
        m4 = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        simulate();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}