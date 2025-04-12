import java.util.*;
import java.io.*;


public class Main {
    public static int n, t;
    public static int[][] grid;
    public static char[] commandArray;
    public static int dirNum;
    public static int sum;

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static void changeDir(char dir) {
        if(dir == 'L'){
            dirNum = (dirNum + 3) % 4;
        }
        else if(dir == 'R'){
            dirNum = (dirNum + 1) % 4;
        }


    }

    public static boolean inRange(int x, int y){
        return ( 1 <= x && x <= n && 1 <= y && y <= n );
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        dirNum = 0;

        grid = new int[n+1][n+1];
        String str = br.readLine();

        commandArray = str.toCharArray();

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int x = n / 2 + 1;
        int y = n / 2 + 1;

        sum = grid[x][y];

        for(char dir : commandArray) {
            
            if(dir == 'F'){
                int nx = x + dx[dirNum];
                int ny = y + dy[dirNum];

                if(inRange(nx, ny)){
                    sum += grid[nx][ny];
                    x = nx;
                    y = ny;
                }
            }
            else{
                changeDir(dir);
            }
        }

        System.out.print(sum);

            
    }
}