// import java.util.*;
// import java.io.*;

// class Pair{
//     int x, y;
//     public Pair(int x, int y){
//         this.x = x;
//         this.y = y
//     }
// }
// public class Main {
//     public static int n, k;
//     public static int startX, startY, endX, endY;
//     public static int[][] answer;
//     public static boolean[][] visited;
//     public static int[][] step;
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

//     public static void push(int x, int y, int s){
//         visited[x][y] = true;
//         step[x][y] = s;
//         q.add(new Pair(x, y));
//     }

//     public static void BFS(){
//         int dx[] = new int[]{1, 0, -1, 0};
//         int dy[] = new int[]{0, 1, 0, -1};

//         while(!q.isEmpty()){
//             Pair curr = q.poll();
//             int x = curr.x, y = curr.y;

//             for(int i = 0; i < 4; i++){
//                 int nx = x + dx[i];
//                 int ny = y + dy[i];
//                 if(canGo(nx, ny)){
//                     push(nx, ny, step[x][y] + 1);
//                 }
//             }
//         }
//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         n = Integer.parseInt(st.nextToken());
//         k = Integer.parseInt(st.nextToken()); // 벽의 개수

//         answer = new int[n+1][n+1];
//         visited = new boolean[n+1][n+1];
//         step = new int[n+1][n+1];

//         for(int i = 1; i <= n; i++){
//             st = new StringTokenizer(br.readLine());
//             for(int j = 1; j <= n; j++){
//                 answer[i][j] = Integer.parseInt(st.nextToken());
//             }
//         }

//         st = new StringTokenizer(br.readLine());

//         startX = Integer.parseInt(st.nextToken());
//         startY = Integer.parseInt(st.nextToken());
//         endX = Integer.parseInt(st.nextToken());
//         endX = Integer.parseInt(st.nextToken());

        

//     }
// }

import java.util.*;
import java.io.*;

class Pair {
    int x, y, remainingK;

    public Pair(int x, int y, int remainingK) {
        this.x = x;
        this.y = y;
        this.remainingK = remainingK;
    }
}

public class Main {
    public static int n, k;
    public static int startX, startY, endX, endY;
    public static int[][] answer;
    public static boolean[][][] visited;
    public static int[][][] step; 
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return (1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static boolean canGo(int x, int y, int remainingK) {
        if (!inRange(x, y)) return false;
        if (visited[x][y][remainingK]) return false;
        return true;
    }

    public static void push(int x, int y, int s, int remainingK) {
        visited[x][y][remainingK] = true;
        step[x][y][remainingK] = s;
        q.add(new Pair(x, y, remainingK));
    }

    public static void BFS() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x, y = curr.y, remainingK = curr.remainingK;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

               
                if (canGo(nx, ny, remainingK) && answer[nx][ny] == 0) {
                    push(nx, ny, step[x][y][remainingK] + 1, remainingK);
                }

                
                if (remainingK > 0 && canGo(nx, ny, remainingK - 1) && answer[nx][ny] == 1) {
                    push(nx, ny, step[x][y][remainingK] + 1, remainingK - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); 

        answer = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1][k + 1]; 
        step = new int[n + 1][n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

         st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

        // Initialize BFS
        push(startX, startY, 0, k); 
        BFS();

        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            if (visited[endX][endY][i]) {
                result = Math.min(result, step[endX][endY][i]);
            }
        }

        // Output the shortest distance or -1 if unreachable
        bw.write(String.valueOf(result == Integer.MAX_VALUE ? -1 : result));
        bw.flush();
        bw.close();
    }
}
