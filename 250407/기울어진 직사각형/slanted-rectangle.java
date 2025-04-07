import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] answer;

    public static int[] dx = new int[]{-1, -1, 1, 1};
    public static int[] dy = new int[]{1, -1, -1, 1};

    public static boolean inRange(int x, int y){
        return (0 <= x && x < n && 0 <= y && y < n);
    }

    public static int getScore(int x, int y, int w, int h) {
    int[] moveSize = {w, h, w, h};
    int total = 0;

    for (int dir = 0; dir < 4; dir++) {
        for (int i = 0; i < moveSize[dir]; i++) {
            x += dx[dir];
            y += dy[dir];

            if (!inRange(x, y)) {
                return 0;
            }

            total += answer[x][y];
        }
    }

    return total;
}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        answer = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxScore = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                for(int w = 1; w < n; w++){
                    for(int h = 1; h < n; h++){
                        maxScore = Math.max(maxScore, getScore(i,j,w,h));
                    }
                }
            }
        }

        System.out.print(maxScore);


    }
}