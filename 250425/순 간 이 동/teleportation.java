import java.util.*;
import java.io.*;

public class Main {
    public static int A, B, x, y; // A ~ B 까지 걸어가야 하는데 딱 한번 순간 이동 ㄱㄴ
    // x에서 y로 or y -> x

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        // 자 경우에 수는 3가지 
        // 1. A -> x -> y -> B
        // 2. A -> y -> x -> B
        // 3. A -> B

        // 3번부터
        int minLen = Integer.MAX_VALUE;

        // 3번
        minLen = Math.min(minLen, Math.abs(B-A));
        // 1번
        minLen = Math.min(minLen, Math.abs((x - A)) + Math.abs((y - B)));

        //2번
        minLen = Math.min(minLen, Math.abs((x - B)) + Math.abs((y - A)));

        System.out.print(minLen);
    }
}