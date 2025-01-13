import java.util.*;
import java.io.*;

class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int n, m;
    public static int[][] answer;
    public static boolean[][] visited;
    public static int[][] step;
    public static Queue<Pair> q = new LinkedList<>();

    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y){
        return ( 1 <= x && x <= n && 1 <= y && y <= m);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y))
            return false;
        if(answer[x][y] == 0 || visited[x][y] == true)
            return false;
        
        return true;
    }  

    public static void push(int x, int y, int s){
        step[x][y] = s;
        visited[x][y] = true;
        q.add(new Pair(x,y));
    }

    public static void BFS(){
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(canGo(nx, ny)){
                    push(nx, ny, step[x][y] + 1);
                    // System.out.printf("x: %d y: %d step: %d\n", nx, ny, step[x][y]);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        step = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        push(1,1,0);
        BFS();

        bw.write(String.valueOf(step[n][m]));
        bw.flush();
        bw.close();
    }
}