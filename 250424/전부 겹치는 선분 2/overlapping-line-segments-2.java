import java.util.*;
import java.io.*;

class Pair {
    int x1, x2;
    public Pair(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}

public class Main {
    public static int n;
    public static Pair[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        answer = new Pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            answer[i] = new Pair(x1, x2);
        }

        boolean condition = false;

        for (int i = 0; i < n; i++) {
            int maxX = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                Pair dot = answer[j];
                maxX = Math.max(maxX, dot.x1);
                minX = Math.min(minX, dot.x2);
            }

            if (minX >= maxX) {
                condition = true;
                break;  // 하나라도 가능하면 바로 종료
            }
        }

        System.out.println(condition ? "Yes" : "No");
    }
}
