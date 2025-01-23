import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k;
    public static int[][] answer; 
    public static int lastRow = 0;
    // public static boolean inRange(int col){
    //     return ( k + m - 1 <= n);
    // }
    public static boolean canGo(int row){
        for(int i = k; i <= (k + m - 1); i++){
            if(answer[row][i] != 0)
                return false;
        }
        return true;
    }

    public static void move(int row){
        int nextRow = row + 1;
        
        if(canGo(nextRow)){
            lastRow = nextRow;
            // System.out.print("test");
            // for(int i = k; i <= (k + m - 1); i++){
            //     answer[nextRow][i] = 1;
            // }
            move(nextRow);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        answer = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move(0);
        for(int i = k; i <= (k + m - 1); i++){
                answer[lastRow][i] = 1;
            }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}