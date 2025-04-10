import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k;
    public static int[][] answer;
    public static int[][] nextGrid;
    public static int[] temp;

    public static void simulate() {
        // 초기 폭탄 제거
        for (int col = 0; col < n; col++) {
            removeBombsInColumn(col);
        }

        for (int i = 0; i < k; i++) {
            rotate(); // 90도 회전

            // 회전 후 폭탄 처리
            for (int col = 0; col < n; col++) {
                moveBomb(col);
                removeBombsInColumn(col);
            }
        }
    }

    // 하나의 열에 대해 폭탄 제거 처리
    public static void removeBombsInColumn(int col) {
        boolean changed = true;
        while (changed) {
            List<int[]> bombTargets = new ArrayList<>();
            int count = 1;
            for (int row = 1; row < n; row++) {
                if (answer[row][col] != 0 && answer[row][col] == answer[row - 1][col]) {
                    count++;
                } else {
                    if (count >= m) {
                        bombTargets.add(new int[]{row - count, row});
                    }
                    count = 1;
                }
            }
            if (count >= m) {
                bombTargets.add(new int[]{n - count, n});
            }

            // 폭탄이 없으면 종료
            if (bombTargets.isEmpty()) {
                changed = false;
            } else {
                // 폭탄 제거
                for (int[] range : bombTargets) {
                    for (int i = range[0]; i < range[1]; i++) {
                        answer[i][col] = 0;
                    }
                }
                // 터진 후 블록 아래로 이동
                moveBomb(col);
            }
        }
    }

    // 블록을 아래로 이동
    public static void moveBomb(int col) {
        int idx = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (answer[i][col] != 0) {
                temp[idx--] = answer[i][col];
            }
        }
        // 나머지 위쪽은 0으로
        while (idx >= 0) {
            temp[idx--] = 0;
        }
        for (int i = 0; i < n; i++) {
            answer[i][col] = temp[i];
        }
    }

    // 90도 회전
    public static void rotate() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                nextGrid[i][j] = answer[n - j - 1][i];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                answer[i][j] = nextGrid[i][j];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        answer = new int[n][n];
        nextGrid = new int[n][n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate();

        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (answer[i][j] != 0)
                    cnt++;

        System.out.print(cnt);
    }
}
