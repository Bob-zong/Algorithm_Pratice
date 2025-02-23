import java.util.*;
import java.io.*;

public class Main {
    public static int row, col;
    public static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        answer = new int[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                String color = st.nextToken();
                if(color.equals("W"))
                    answer[i][j] = 0;
                else
                    answer[i][j] = 1; 
            }
        }        
        
        int cnt = 0;

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                for(int x = i+1; x < row-1; x++){
                    for(int y = j+1; y < col-1; y++){
                        if(answer[0][0] != answer[i][j] && answer[i][j] != answer[x][y] && answer[x][y] != answer[row-1][col-1])
                            cnt +=1;
                    }
                }    
            }
        }    
        System.out.print(cnt);    

    }
}