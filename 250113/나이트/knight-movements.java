import java.util.*;
import java.io.*;

class Pair{
    int x, y;
    public Pair(int x , int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int n;
    public static boolean[][] visited;
    public static int[][] step;
    public static int startX, startY, endX, endY;
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y){
        return ( 1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static boolean canGo(int x, int y){
        if(!inRange(x, y))
            return false;
        if(visited[x][y] == true)
            return false;

        return true;
    }

    public static void push(int x, int y, int s){
        visited[x][y] = true;
        step[x][y] =s;
        q.add(new Pair(x,y));
    }

    public static void BFS(){
        int dx[] = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int dy[] = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;
            
            for(int i = 0; i < dx.length; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(canGo(nx,ny)){
                    push(nx,ny, step[x][y]+1);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1][n+1];
        step = new int[n+1][n+1];
        push(startX, startY, 0);
        BFS();

        if(visited[endX][endY])
            bw.write(String.valueOf(step[endX][endY]));
        else{
            bw.write(-1);
        }
        bw.flush();
        bw.close();
        
    }
}