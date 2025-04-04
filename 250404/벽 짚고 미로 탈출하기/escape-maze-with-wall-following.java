import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int time;
    public static int[][] answer;
    public static int[][] visited;

    public static int startX, startY;
    public static int dirNum = 0;

    public static int[] dx = new int[]{0, -1, 0, 1}; // 오른쪽 위 왼쪽 아래
    public static int[] dy = new int[]{1, 0, -1 ,0};

    public static boolean inRange(int x, int y) {
        return (1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static boolean checkWall(int x, int y) {
        return answer[x][y] == 1;
    }

    public static void changeDir(int type) {
        if (type == 0)
            dirNum = (dirNum + 1) % 4; // 반시계 방향
        else  
            dirNum = (dirNum + 3) % 4; // 시계방향 전환
    }

    public static void simulate() {
        time = 0;
        int x = startX;
        int y = startY;
        visited[x][y] = 1;
        int loopCheck = 0;  // 무한 루프 방지를 위한 카운트

        while (true) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if (!inRange(nx, ny)) { // 범위를 벗어나면 종료
                time += 1;
                break;
            }

            if (visited[nx][ny] >= 2) { // 같은 곳을 여러 번 방문하면 종료
                time = -1;
                break;
            }

            if (checkWall(nx, ny)) { // 벽이 있을 경우 방향을 반시계로 변경 후 다시 체크
                changeDir(0);
                loopCheck++;  // 회전 횟수 증가

                if (loopCheck >= 4) { // 4번 이상 방향 전환만 하면 더 이상 이동 불가능
                    time = -1;
                    break;
                }
                continue;
            }

            // 벽이 없으면 이동
            x = nx;
            y = ny;
            time += 1;
            visited[x][y] += 1;
            loopCheck = 0;  // 이동을 하면 회전 카운트 초기화

            // 이동 후, 현재 바라보는 방향에서 시계 방향으로 변경 후 이동할 수 있는지 확인
            int nextDir = (dirNum + 3) % 4;
            int nextX = x + dx[nextDir];
            int nextY = y + dy[nextDir];

            if (!checkWall(nextX, nextY) && inRange(nextX, nextY)) {
                changeDir(1);  // 시계 방향으로 회전 후 이동
                x = nextX;
                y = nextY;
                time += 1;
                visited[x][y] += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        answer = new int[n + 1][n + 1];
        visited = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= n; j++) {
                if (str.charAt(j - 1) == '#')
                    answer[i][j] = 1;
                else
                    answer[i][j] = 0;
            }
        }

        simulate();

        System.out.print(time);
    }
}
