import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, q;
    public static int[][] answer; 
    public static char changeDir(char dir){
        return ( (dir == 'L') ? 'R' : 'L');
    }
    public static void shift(int row, char dir) {
        if(dir == 'R'){
          int temp = answer[row][1];
          for(int i = 1; i < m; i++){
            answer[row][i] = answer[row][i+1];
          }
          answer[row][m] = temp;

        }
        else{
            int temp = answer[row][m];
            for(int i = m; i > 1; i--){
                answer[row][i] = answer[row][i-1];
            }
            answer[row][1] = temp;
            
        }      
    }
    public static void simulate(int startRow, char startDir) {
        // 입력받은 row와 방향으로 shift 진행
        shift(startRow, startDir); 
        char dir = startDir;
        //위쪽 방향 전파 시도
        for(int row = startRow; row >= 2; row--){
            if(checkUp(row)){
                dir = changeDir(dir);
                shift(row-1, dir);
            }
            else{
                break;
            }
        }
        
        dir = startDir;
        //아래쪽 방향 전파 시도
        for(int row = startRow; row < n; row++){
            if(checkDown(row)){
                dir = changeDir(dir);
                shift(row+1, dir);
            }
            else{
                break;
            }
        }
    
    }
    public static boolean checkUp(int row) {
        if(row - 1 < 1)
            return false;

        for(int i = 1; i <= m; i++){
            if(answer[row-1][i] == answer[row][i])
                return true;
        }

        return false;
    }

    public static boolean checkDown(int row) {
        if(row + 1 > n)
            return true;

        for(int i = 1; i <= m; i++){
            if(answer[row+1][i] == answer[row][i])
                return true;
        }
        
        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        answer = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            char ch = str.charAt(0);

            simulate(row, ch);
        }

        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        // 입력받은 row 행 shift 진행 -> n
        // 각 열에 대해서 값이 똑같은게 있는지 완전 탐색으로 확인 2m 
        // 시간 복잡도 -> m n;
        // 입력받은 q 회수만큼 또 진행 m * n * q -> 백만
    }
}