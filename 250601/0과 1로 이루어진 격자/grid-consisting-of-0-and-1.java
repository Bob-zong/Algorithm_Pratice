import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            String[] num = br.readLine().split("");

            for(int j = 1; j <= n; j++){
                board[i][j] = Integer.parseInt(num[j-1]);
            }
        }    

        int cnt = 0;

        for(int i = n; i >= 1; i--){
            for(int j = n; j >= 1; j--){
                if(board[i][j] == 1){
                    cnt++;

                    for(int x = 1; x <= i; x++){
                        for(int y = 1; y <= j; y++){
                            board[x][y] = 1 - board[x][y]; 
                        }
                    }
                }
                
            }
        }

        System.out.print(cnt);
    }
}