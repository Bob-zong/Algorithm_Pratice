import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] answer;

    public static int getDistance(int dot1, int dot2) {
        int x1, y1, x2, y2;

        x1 = answer[dot1][0];
        y1 = answer[dot1][1];
        x2 = answer[dot2][0];
        y2 = answer[dot2][1];

        int dist = ((x2-x1) * (x2-x1)) + ((y2-y1) * (y2-y1));
        return dist;
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int minDistance = Integer.MAX_VALUE;

        n = Integer.parseInt(br.readLine());

        answer = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                minDistance = Math.min(minDistance,getDistance(i,j));
            }
        }

        System.out.print(minDistance);
    }
}