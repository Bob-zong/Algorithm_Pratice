import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = 6;

        int[] answer = new int[n];

        for(int i = 0; i < n; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(answer);

        // a <= b <= c
        // 최소 = a
        // 그다음이 무조건 b
        // a + b 는 알 수 있고,
        // 최대값이 a + b + c 니까
        // 최대 - a + b 하면 c 나오네

        int a = answer[0];
        int b = answer[1];
        int c = answer[n-1] - (a + b);

        System.out.printf("%d %d %d", a, b, c);
    }
}