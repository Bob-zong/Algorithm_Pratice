// import java.util.*;
// import java.io.*;

// public class Main {
//     public static int n;
//     public static int[][] board;
//     public static int ans = 0;

//     public static int[] dx = new int[]{-1, 0, 1, 0};
//     public static int[] dy = new int[]{0, 1, 0, -1};

//     public static int changeDir(int dir, int type) {
//         if(type == 1){ // /
//             if(dir == 0) return 3; // 상 → 우
//             if(dir == 1) return 2; // 우 → 상
//             if(dir == 2) return 1; // 하 → 좌
//             if(dir == 3) return 0; // 좌 → 하
//         } else if(type == 2){ // \
//             if(dir == 0) return 1; // 상 → 좌
//             if(dir == 1) return 0; // 우 → 하
//             if(dir == 2) return 3; // 하 → 우
//             if(dir == 3) return 2; // 좌 → 상
//         }
//         return -1; // 예외 상황
//     }
//     public static boolean inRange(int x, int y) {
//         return (1 <= x && x <= n && 1 <= y && y <= n);
//     }

//     public static int move(int row, int col, int dir) {
//         int cnt = 0;
//         int x = row;
//         int y = col;
//         int currDir = dir;

//         if(board[x][y] != 0)
//             currDir = changeDir(dir, board[x][y]);

//         while(inRange(x, y)) {
//             int nx = x + dx[currDir];
//             int ny = y + dy[currDir];
//             cnt++;

//             if(inRange(nx, ny)) {
//                 x = nx;
//                 y = ny;

//                 if(board[nx][ny] != 0) {
//                     currDir = changeDir(currDir, board[nx][ny]);
//                 }

//             }else{
//                 cnt++;
//                 break;
//             }
            
//         }

//         return cnt;
        
//     }
    
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;

//         n = Integer.parseInt(br.readLine());

//         board = new int[n+1][n+1];

//         for(int i = 1; i <= n; i++) {
//             st = new StringTokenizer(br.readLine());

//             for(int j = 1; j <= n; j++){
//                 board[i][j] = Integer.parseInt(st.nextToken());
//             }
//         }

//         for(int i = 1; i <= n; i++) {
//             ans = Math.max(ans, move(1, i, 2));
//             ans = Math.max(ans, move(n, i, 0));
//             ans = Math.max(ans, move(i, 1, 1));
//             ans = Math.max(ans, move(i, n, 3));
//         }

//         System.out.print(ans);
        
//     }
// }

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n, arr[][] = new int[100][100], dir[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}}, res;
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }        
        solution();
    }

    static void solution(){
        for(int k=0; k<n; k++){
            move(0, k, dir[0]);
            move(n-1, k, dir[1]);
            move(k, 0, dir[2]);
            move(k, n-1, dir[3]);
        }
        System.out.println(res);
    }

    static void move(int i, int j, int[] d){
        int[] td = d.clone();
        int cnt = 1;
        while(i >= 0 && i < n && j >= 0 && j < n){
            if(arr[i][j] != 0) changeDir(i, j, td);
            i += td[0];
            j += td[1];
            cnt++;
        }
        res = Math.max(res, cnt);
    }

    static void changeDir(int i, int j, int[] td){
        if(arr[i][j] == 1){ // /
            if(td[0] == 1 && td[1] == 0){ // 하
                // 좌
                td[0] = 0;
                td[1] = -1;
            }
            else if(td[0] == -1 && td[1] == 0){ // 상
                // 우
                td[0] = 0;
                td[1] = 1;
            }
            else if(td[0] == 0 && td[1] == 1){ // 우
                // 상
                td[0] = -1;
                td[1] = 0;
            }
            else if(td[0] == 0 && td[1] == -1){ // 좌
                // 하
                td[0] = 1;
                td[1] = 0;
            }
        }
        else if(arr[i][j] == 2){ // \
            if(td[0] == 1 && td[1] == 0){ // 하
                // 우
                td[0] = 0;
                td[1] = 1;
            }
            else if(td[0] == -1 && td[1] == 0){ // 상
                // 좌
                td[0] = 0;
                td[1] = -1;
            }
            else if(td[0] == 0 && td[1] == 1){ // 우
                // 하
                td[0] = 1;
                td[1] = 0;
            }
            else if(td[0] == 0 && td[1] == -1){ // 좌
                // 상
                td[0] = -1;
                td[1] = 0;
            }
        }
    }
}