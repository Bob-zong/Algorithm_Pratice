import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(0); // 초기 위치

        int minDist = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            Integer lower = tree.floor(x);   // 가장 가까운 작은 값
            Integer higher = tree.ceiling(x); // 가장 가까운 큰 값

            if (lower != null)
                minDist = Math.min(minDist, Math.abs(x - lower));
            if (higher != null)
                minDist = Math.min(minDist, Math.abs(x - higher));

            tree.add(x); // 삽입
            sb.append(minDist).append("\n");
        }

        System.out.print(sb);
    }
}
