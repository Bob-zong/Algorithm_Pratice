import java.util.*;
import java.io.*;

public class Main {
    // 2차원 방향 배열을 만들어서 방향을 각 행의 구슬이 어디로 이동할지 관리
    // 각 공간에 구슬이 몇 개 있는지 관리
    //완전 탐색을 진행하며 각 구슬을 이동 -> n^2
    // 구슬이 2개 이상일 경우 삭제하는 로직 o(1)
    // 충분히 오랜 시간은 어차피 벽에 시작부터 끝까지 갔다가 돌아오는 시간이면 충분함 2 * n
    // 2n -> n^2 : 2n^3
    // n이 50이니까 
    public static int T, n, m; // T -> 테스트 케이스 수, n 격자 크기, m : 구슬의 개수
    public static int execTime;
    public static int dirNum;

    public static int[][] answer;
    public static int[][] dirArr;
    public static int[][] nextGrid;
    public static int[][] nextDirArr;


    public static int[] dx = new int[]{-1, 0, 0, 1};
    public static int[] dy = new int[]{0, 1, -1, 0};
    
    public static int getDir(char dir){
        if(dir == 'U'){
            return 0;
        }
        else if(dir == 'R'){
            return 1;
        }
        else if(dir == 'L'){
            return 2;
        }
        else{
            return 3;
        }
    }
    
    public static boolean inRange(int x, int y){
        return ( 1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static void copyArr(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                answer[i][j] = nextGrid[i][j];
                dirArr[i][j] = nextDirArr[i][j];
            }
        }
    }

    public static void initNextArr(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                nextDirArr[i][j] = 0;
                nextGrid[i][j] = 0; 
            }
        }
    }
    public static void simulate(){
        int time = 0;
        while(time++ <= execTime){
            
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(answer[i][j] != 0){
                        dirNum = dirArr[i][j];
                        int nx = i + dx[dirNum];
                        int ny = j + dy[dirNum];
                        if(inRange(nx, ny)){
                            nextGrid[nx][ny] += 1;
                            nextDirArr[nx][ny] = dirNum;
                        }
                        else{
                            nextDirArr[i][j] = 3 - dirNum;
                            nextGrid[i][j] = 1; // 구슬은 제자리에 남아 있음
                        }
                    }
                }
            }

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(nextGrid[i][j] >= 2){
                        nextGrid[i][j] = 0;
                        nextDirArr[i][j] = 0;
                    }
                }
            }
            copyArr();
            initNextArr();
        }
    }

    public static int getCnt(){
        int cnt = 0 ;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(answer[i][j] != 0){
                    cnt += 1;
                }
            }
        }

        return cnt;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());


        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            execTime = 2 * n;

            answer = new int[n+1][n+1];
            nextGrid = new int[n+1][n+1];
            dirArr = new int[n+1][n+1];
            nextDirArr = new int[n+1][n+1];

            for(int i = 1; i <= m; i++){

                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                String str = st.nextToken();

                int dir = getDir(str.charAt(0));

                answer[row][col] = 1;
                dirArr[row][col] = dir;
            }

            simulate();

            int cnt = getCnt();
            sb.append(cnt).append("\n");
        }
        
        System.out.print(sb);
        
    }
}