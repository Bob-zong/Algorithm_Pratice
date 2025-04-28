import java.util.*;
import java.io.*;
class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int n, k;
    public static int[][] answer;
    public static boolean[][] visited;

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    
    public static Queue<Pair> q = new LinkedList<>();
    
    public static boolean inRange(int x, int y) {
        return ( 1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y))
            return false;
        
        if(answer[x][y] == 1 || visited[x][y] == true)
            return false;
        
        return true;
    }

    public static void BFS() {
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(nx, ny)) {
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        answer = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            q.add(new Pair(row, col));
            visited[row][col] = true;
        }

        BFS();

        int cnt = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(visited[i][j] == true)
                    cnt +=1;
            }
        }

        System.out.print(cnt);
    }
}


// import java.util.*;
// import java.io.*;

// class Pair{
//     int x, y;
//     public Pair(int x, int y){
//         this.x = x;
//         this.y = y;
//     }
// }

// public class Main {
//     public static int n, k;
//     public static int[][] answer;
//     public static boolean[][] visited;
//     public static int[] dx = new int[]{1, 0, -1, 0};
//     public static int[] dy = new int[]{0, 1, 0, -1};
//     public static Queue<Pair> q = new LinkedList<>();

//     public static boolean inRange(int x, int y){
//         return ( 1 <= x && x <= n && 1 <= y && y <= n);
//     }
    
//     public static boolean canGo(int x, int y){
//         if(!inRange(x, y))
//             return false;
//         if(answer[x][y] == 1 || visited[x][y] == true)
//             return false;
        
//         return true;
//     }

//     public static void BFS(){
//         while(!q.isEmpty()){
//             Pair curr = q.poll();
//             int x = curr.x, y = curr.y;

//             for(int i = 0; i < 4; i++){
//                 int nx = x + dx[i];
//                 int ny = y + dy[i];
//                 if(canGo(nx ,ny)){
//                     // System.out.println("x: " + nx + " y: " + ny);
//                     visited[nx][ny] = true;
//                     q.add(new Pair(nx, ny));
//                 }
//             }
//         }
//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         StringTokenizer st = new StringTokenizer(br.readLine());
        
//         n = Integer.parseInt(st.nextToken());
//         k = Integer.parseInt(st.nextToken());
//         answer = new int[n+1][n+1];
//         visited = new boolean[n+1][n+1];

//         for(int i = 1; i <= n; i++){
//             st = new StringTokenizer(br.readLine());
//             for(int j = 1; j <= n; j++){
//                 answer[i][j] = Integer.parseInt(st.nextToken());
//             }
//         }
        
//         for(int i = 0; i < k; i++){
//             st = new StringTokenizer(br.readLine());
//             int row = Integer.parseInt(st.nextToken());
//             int col = Integer.parseInt(st.nextToken());
//             q.add(new Pair(row, col));
//             visited[row][col] = true;
//             BFS();
//         }

//         int cnt = 0;
//         for(int i = 1; i <= n; i++){
//             for(int j = 1; j <= n; j++){
//                 if(visited[i][j] == true)
//                     cnt += 1;
//             }
//         }
        
//         bw.write(String.valueOf(cnt));
//         bw.flush();
//         bw.close();

//     }
// }
