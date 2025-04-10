import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k;
    public static int[][] answer;

    public static void simulate() {
        // 초기 폭탄 제거
        for (int col = 0; col < n; col++) {
            removeBombsInColumn(col);
        }

        for (int t = 0; t < k; t++) {
            rotate();  // 메모리 낭비 없이 회전
            for (int col = 0; col < n; col++) {
                moveBomb(col);
                removeBombsInColumn(col);
            }
        }
    }

    public static void removeBombsInColumn(int col) {
        boolean changed = true;
        while (changed) {
            List<int[]> bombRanges = new ArrayList<>();
            int count = 1;

            for (int row = 1; row < n; row++) {
                if (answer[row][col] != 0 && answer[row][col] == answer[row - 1][col]) {
                    count++;
                } else {
                    if (count >= m) {
                        bombRanges.add(new int[]{row - count, row});
                    }
                    count = 1;
                }
            }

            if (count >= m) {
                bombRanges.add(new int[]{n - count, n});
            }

            if (bombRanges.isEmpty()) {
                changed = false;
            } else {
                for (int[] range : bombRanges) {
                    for (int i = range[0]; i < range[1]; i++) {
                        answer[i][col] = 0;
                    }
                }
                moveBomb(col);
            }
        }
    }

    public static void moveBomb(int col) {
        int write = n - 1;
        for (int read = n - 1; read >= 0; read--) {
            if (answer[read][col] != 0) {
                answer[write--][col] = answer[read][col];
            }
        }
        while (write >= 0) {
            answer[write--][col] = 0;
        }
    }

    public static void rotate() {
        // rotate 시 answer 자체를 덮어쓰기 (temp 없이)
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                rotated[i][j] = answer[n - j - 1][i];

        // 덮어쓰기
        answer = rotated;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        answer = new int[n][n];

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
