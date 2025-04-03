import java.util.*;
import java.io.*;

class Pair {
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int n, m;
    public static final int DIRNUM = 8;

    public static int[][] answer;
    
    public static int[] dx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    public static int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};

    public static boolean inRange(int x, int y){
        return (1 <= x && x <= n && 1 <= y && y <= n);
    }
    
    public static Pair FindPos(int num) {
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                if(answer[i][j] == num)
                    return new Pair(i, j);
        
        return new Pair(0, 0);
    }
    public static void swap(Pair pos, Pair nextPos) {
        int x = pos.x;
        int y = pos.y;
        
        int nx = nextPos.x;
        int ny = nextPos.y;
    
        int temp = answer[x][y];
        answer[x][y] = answer[nx][ny];
        answer[nx][ny] = temp;
    }

    public static void simulate() {
        for(int num = 1; num <= n*n; num++){
            Pair pos = FindPos(num);
            Pair nextPos = NextPos(pos);
            swap(pos, nextPos);
        }
    }

    public static Pair NextPos(Pair pos) {      
        int x = pos.x;
        int y = pos.y;
        
        // 인접한 8개의 칸 중 가장 값이 큰 위치를 찾아 반환합니다.
        int maxVal = -1;
        Pair maxPos = new Pair(0, 0);
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if(inRange(nx, ny) && answer[nx][ny] > maxVal) {
                maxVal = answer[nx][ny];
                maxPos = new Pair(nx, ny);
            }
        }
        
        return maxPos;
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
        
        // 숫자를 순서대로 찾기 n^2 * 8;
        while(m-- > 0)
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