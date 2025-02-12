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
    public static int n, k;
    public static int[][] answer;
    public static int[][] step;
    public static boolean[][] visited;
    public static Queue<Pair> q = new LinkedList<>();
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y){
        return ( 0 <= x && x < n && 0 <= y && y < n);
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
                int nx = x + dx[i], ny = y + dy[i];

                if(canGo(nx, ny)){
                    push(nx, ny, step[x][y] + 1);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        answer = new int[n][n];
        visited = new boolean[n][n];
        step = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
               answer[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(answer[i][j] == 2){
                    push(i, j, 0);
                }
            }
        }

        BFS();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(step[i][j] == 0 && answer[i][j] == 1){
                    step[i][j] = -2;
                }
                if(step[i][j] == 0){
                    step[i][j] = -1;
                }
                if(answer[i][j] == 2){
                    step[i][j] = 0;
                }
                sb.append(step[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}