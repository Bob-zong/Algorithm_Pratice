import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int r, c;
    public static int currDir;

    public static int[][] board;
    public static char[] direction;

    public static int[] dx = new int[]{0, 0, -1, 1};
    public static int[] dy = new int[]{-1, 1, 0, 0};
    
    
    public static int getNum(int num) {
        return 7 - num;
    }

    public static int getDirNum(char dir) {
        if(dir == 'L')  
            return 0;
        else if(dir == 'R') 
            return 1;
        else if(dir == 'U') 
            return 2;
        else 
            return 3;
    }
    public static void simulate() {
        int x, y;

        x = r;
        y = c;

        board[x][y] = 6;

        //위 앞 오른쪽 3개를 관리할까

        int up, front, right;

        up = 1;
        front = 2;
        right = 3;

        for(int i = 0; i < m; i++) {
            int dirNum = getDirNum(direction[i]);
            
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if(inRange(nx, ny)){
                x = nx;
                y = ny;
                // 왼쪽 -> 위 오른쪽 바뀜
                // 오른쪽 -> 위 왼쪽 바뀜
                // 앞 -> 위 앞 바뀜
                // 뒤 -> 위 뒤 바뀜
                if(dirNum == 0){
                    int temp = up;
                    up = right;
                    right = getNum(temp);
                }
                else if(dirNum == 1){
                    int temp = up;
                    up = getNum(right);
                    right = temp;
                }
                else if(dirNum == 2){
                    int temp = up;
                    up = front;
                    front = getNum(temp);
                }
                else{
                    int temp = up;
                    up = getNum(front);
                    front = temp;
                }

                board[x][y] = getNum(up);
            }


        }

    }

    public static boolean inRange(int x, int y) {
        return (1<= x && x <= n && 1 <= y && y <= n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];
        direction = new char[m];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++)
            direction[i] = st.nextToken().charAt(0);

        simulate();

        int ans = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                // System.out.print(board[i][j] + " ");
                ans += board[i][j];
            }
                // ans += board[i][j];
        }

        System.out.print(ans);

    }
}