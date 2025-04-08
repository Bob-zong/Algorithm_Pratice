import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] answer;
    public static int m1, m2, m3, m4;
    public static int dir;
    public static int row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        answer = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        m1 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
        m3 = Integer.parseInt(st.nextToken());

    }
}