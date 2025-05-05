import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NUM = 100000;
    public static final int MAX_C = 3;

    // public static int[] answer;
    public static int[][] prefixSum;
    
    public static int n, q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        // answer = new int[MAX_NUM+1];
        prefixSum = new int[MAX_C+1][MAX_NUM+1];

        for(int i = 1; i <= n; i++){
            int num = Integer.parseInt(br.readLine());

            for(int c = 1; c <= 3; c++) {
                prefixSum[c][i] = prefixSum[c][i-1];
            }

            prefixSum[num][i]++;
        }


        for(int i = 1; i <= q; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int rock1 = prefixSum[1][e] - prefixSum[1][s-1];
            int rock2 = prefixSum[2][e] - prefixSum[2][s-1];
            int rock3 = prefixSum[3][e] - prefixSum[3][s-1];

            sb.append(rock1).append(" ").append(rock2).append(" ").append(rock3);
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

