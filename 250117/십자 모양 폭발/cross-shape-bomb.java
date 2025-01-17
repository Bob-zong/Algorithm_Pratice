import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int targetX, targetY;
    public static int[][] answer;
    public static int[] temp;

    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    
    public static boolean inRange(int x, int y){
        return ( 1 <= x && x <= n && 1 <= y && y <= n);
    }
    
    public static void gridBoom(int x, int y){
        int size = answer[x][y];

        for(int k = 0; k < size; k++){
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i] * k;
                int ny = y + dy[i] * k;
                if(inRange(nx, ny)){
                    answer[nx][ny] = 0;
                }
            }
        }
    }

    public static void moveArr(){
        int tempEndIdx = 1;

        for(int col = 1; col <= n; col++){
            for(int row = n; row >= 1; row--){
                if(answer[row][col] != 0)
                    temp[tempEndIdx++] = answer[row][col]; 
            }
            
            tempEndIdx = 1;
            
            for(int row = n; row >= 1; row--){
                answer[row][col] = temp[tempEndIdx++];
            }
            
            tempEndIdx = 1;
            Arrays.fill(temp, 0);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        
        answer = new int[n+1][n+1];
        temp = new int[n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        targetX = Integer.parseInt(st.nextToken());
        targetY = Integer.parseInt(st.nextToken());
        
        gridBoom(targetX, targetY);
        moveArr();
        // for(int i = 1; i <= n; i++){
        //     for(int j = 1; j <= n; j++){
        //         bw.write(answer[i][j] + " ");
        //     }
        //     bw.newLine();
        // }
        
        // bw.flush();
        // bw.close();

    }
}