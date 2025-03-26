import java.util.*;
import java.io.*;

// class Pair {
//     int x, y;
//     public Pair(int x, int y){
//         this.x = x;
//         this.y = y;
//     }
// }

// public class Main {
//     public static int n , row, col;
//     public static int[] dx = new int[]{-1, 1, 0, 0};
//     public static int[] dy = new int[]{0, 0, -1, 1};
//     public static int[][] answer;
//     public static StringBuilder sb;
//     public static Pair maxPos;

//     public static boolean inRange(int x, int y){
//         return (0 < x && x <= n && 0 < y && y <= n);
//     }

//     public static Pair move(int x, int y){
//         int currX, currY;
//         currX = x;
//         currY = y;

//         for(int i = 0; i < 4; i++){
//             int nx, ny;
//             nx = currX + dx[i];
//             ny = currY + dy[i];
//             if(inRange(nx, ny) && answer[nx][ny] > answer[currX][currY]){
//                 maxPos = new Pair(nx, ny);
//                 return maxPos;
//             }
                 
//         }

//         return new Pair(-1, -1);

//     }

//     public static void main(String[] agrs) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;
//         sb = new StringBuilder();

//         st = new StringTokenizer(br.readLine());
//         n = Integer.parseInt(st.nextToken());
//         row = Integer.parseInt(st.nextToken());
//         col = Integer.parseInt(st.nextToken());

//         answer = new int[n+1][n+1];

//         for(int i = 1; i <= n; i++){
//             st = new StringTokenizer(br.readLine());
//             for(int j = 1; j <= n; j++){
//                 answer[i][j] = Integer.parseInt(st.nextToken());
//             }
//         }

//         while(true){
//             Pair ans = new Pair(row, col);
//             ans = move(ans.x, ans.y);
//             if(ans.x == -1 && ans.y == -1)
//                 break;

//             sb.append(answer[ans.x][ans.y]).append(" ");
//         }
        

//         System.out.print(sb);

//     }
// }
public class Main {
    public static int n, row, col;
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[][] answer;
    public static int maxNum;
    public static Pair maxPos;
    public static StringBuilder sb;

    public static boolean inRange(int x, int y){
        return ( 1 <= x && x <= n && 1 <= y && y <= n );
    }
    public static void move(int x, int y){
        int currX, currY;
        currX = x;
        currY = y;

        for(int i = 0; i < 4; i++){
            int nx = currX + dx[i];
            int ny = currY + dy[i];
            if(inRange(nx, ny) && answer[nx][ny] > maxNum){
                maxNum = answer[nx][ny];
                // maxPos = new Pair(nx, ny);
                sb.append(maxNum + " ");
                move(nx, ny);
                break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        answer = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxNum = answer[row][col];
        // Pair maxPos = new Pair(row, col);
        sb.append(maxNum + " ");
        move(row, col);
        System.out.print(sb);

    }
}