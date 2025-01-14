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
    public static int n, h, m;
    public static int[][] answer;
    public static int[][] step;
    public static boolean[][] visited;
    public static Queue<Pair> q = new LinkedList<>();


    public static boolean inRange(int x, int y){
        return ( 1 <= x && x <= n && 1 <= y && y <= n);
    }
    
    public static boolean canGo(int x, int y){
        if(!inRange(x, y))
            return false;
        if(answer[x][y] == 1 || visited[x][y] == true)
            return false;
        
        return true;
    }

    // public static void updateAnswer(int x, int y){
    //     if(answer[x][y] == 3)
    //         answer[x][y] = 2;
    // }

    public static void BFS(){
        int dx[] = new int[]{1, 0, -1, 0};
        int dy[] = new int[]{0, 1, 0, -1};


        while(!q.isEmpty()){
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(canGo(nx,ny)){
                    push(nx, ny, step[x][y] + 1);
                }
            }
        }

    }

    public static void push(int x, int y, int s){
        visited[x][y] = true;
        step[x][y] = s;
        q.add(new Pair(x,y));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken()); // 사람의 수
        m = Integer.parseInt(st.nextToken()); // 비를 피할 수 있는 공간의 수

        answer = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        step = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //answer 포문 돌려서 2가 나오면 BFS 돌리고, 
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(answer[i][j] == 3){
                    push(i, j, 0);
                }
            }
        }
        BFS();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(answer[i][j] != 2){
                    step[i][j] = 0;
                }
                if(answer[i][j] == 2 && visited[i][j] == false)
                    step[i][j] = -1;
            }
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print(step[i][j] + " ");
            }
            System.out.println();
        }
    }
}