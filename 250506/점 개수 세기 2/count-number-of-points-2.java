import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, q;
    public static Pair[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        TreeSet<Integer> xSet = new TreeSet<>();
        TreeSet<Integer> ySet = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        points = new Pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Pair(x, y);
            xSet.add(x);
            ySet.add(y);
        }

        // 좌표 압축 매핑
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        int idx = 0;

        for (int x : xSet) xMap.put(x, ++idx);
        int xSize = idx;

        idx = 0;
        for (int y : ySet) yMap.put(y, ++idx);
        int ySize = idx;

        // 누적합용 배열
        int[][] board = new int[xSize + 2][ySize + 2];

        // 점 위치에 1 표시
        for (Pair p : points) {
            int cx = xMap.get(p.x);
            int cy = yMap.get(p.y);
            board[cx][cy] = 1;
        }

        // 2차원 누적합
        int[][] psum = new int[xSize + 2][ySize + 2];
        for (int i = 1; i <= xSize; i++) {
            for (int j = 1; j <= ySize; j++) {
                psum[i][j] = board[i][j]
                           + psum[i - 1][j]
                           + psum[i][j - 1]
                           - psum[i - 1][j - 1];
            }
        }

        // 압축 좌표 찾기용 TreeSet
        TreeSet<Integer> xKeys = new TreeSet<>(xMap.keySet());
        TreeSet<Integer> yKeys = new TreeSet<>(yMap.keySet());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 가장 가까운 좌표 찾기
            Integer fx1 = xKeys.ceiling(x1);
            Integer fy1 = yKeys.ceiling(y1);
            Integer fx2 = xKeys.floor(x2);
            Integer fy2 = yKeys.floor(y2);

            if (fx1 == null || fy1 == null || fx2 == null || fy2 == null) {
                sb.append("0\n");
                continue;
            }

            int cx1 = xMap.get(fx1);
            int cy1 = yMap.get(fy1);
            int cx2 = xMap.get(fx2);
            int cy2 = yMap.get(fy2);

            // 압축 좌표가 반대로 되어 있으면 점 없음
            if (cx1 > cx2 || cy1 > cy2) {
                sb.append("0\n");
                continue;
            }

            // 2차원 누적합으로 사각형 내 점 개수 구하기
            int count = psum[cx2][cy2]
                      - psum[cx1 - 1][cy2]
                      - psum[cx2][cy1 - 1]
                      + psum[cx1 - 1][cy1 - 1];
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
