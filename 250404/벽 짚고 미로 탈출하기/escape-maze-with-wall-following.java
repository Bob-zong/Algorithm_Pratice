import java.util.*;
import java.io.*;

// 1. 바라보는 방향에 벽이 있는지 체크 있으면 -> 방향 반시계 방향으로 전환, 없으면 직진
// 2. 이동이 가능하면 한칸 전진 후 시계 방향으로 방향 전환 후 한칸 이동
// 다시 1번부터반복 한칸 전진 할 때 레인지를 벗어나면 통과
// visited 배열 사용해서 계속 도는 곳을 돌면 -1 출력

public class Main {
    public static int n;
    public static int time;

    public static int answer[][];
    public static int visited[][];

    public static int startX, startY;
    public static int dirNum = 0;

    public static int[] dx = new int[]{0, -1, 0, 1}; // 오른쪽 위 왼쪽 아래
    public static int[] dy = new int[]{1, 0, -1 ,0};

    public static boolean inRange(int x, int y){
        return ( 1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static boolean checkWall(int x, int y){
        if(answer[x][y] == 1)
            return true;
        else
            return false;
    }

    public static void changeDir(int type){
        if(type == 0)
            dirNum = (dirNum + 1) % 4; //반시계 방향
        else  
            dirNum = (dirNum + 3) % 4; //시계방향 전환
    }

    public static void simulate() {
        time = 0;
        int x = startX;
        int y = startY;
        visited[x][y] = 1;

        while(true) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if(visited[nx][ny] >= 2){
                time = -1;
                break;
            }
            if(!inRange(nx, ny)){
                time += 1;
                break;
            }

            if(checkWall(nx, ny)){
                changeDir(0);
                continue;
            }else{
                changeDir(1);
            }

            x = nx;
            y = ny;
            time += 1;
            visited[x][y] += 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        answer = new int[n+1][n+1];
        visited = new int[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            String str = br.readLine();
            for(int j = 1; j <= n; j++){
                if(str.charAt(j-1) == '#')
                    answer[i][j] = 1;
                else
                    answer[i][j] = 0;
            }
        }

        simulate();

        System.out.print(time);

    }
}