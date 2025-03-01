import java.util.*;
import java.io.*;


public class Main {
    public static final int OFFSET = 1000;
    public static final int MAX_R = 2000;
    public static final int N = 2;
    
    public static int[] x1 = new int[N];
    public static int[] y1 = new int[N];
    public static int[] x2 = new int[N];
    public static int[] y2 = new int[N];
    public static int[][] checked = new int[MAX_R + 1][MAX_R + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            x1[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            y1[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            x2[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            y2[i] = Integer.parseInt(st.nextToken()) + OFFSET;
        }
        
        for(int i = 0; i < N; i++)
            for(int x = x1[i]; x < x2[i]; x++)
                for(int y = y1[i]; y < y2[i]; y++)
                    checked[x][y] = i + 1;

        int minX = MAX_R, maxX = 0, minY = MAX_R, maxY = 0;
        boolean firstRectExist = false;

        for(int x = 0; x <= MAX_R; x++)
            for(int y = 0; y <= MAX_R; y++)
                if(checked[x][y] == 1) {
                    firstRectExist = true;
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                }
        int area;
        // Case 1. 첫 번째 직사각형이 전혀 남아있지 않다면 넓이는 0입니다.
        if(!firstRectExist)
            area = 0;
        // Case 2. 첫 번째 직사각형이 남아있다면, 넓이를 계산합니다.
        else
            area = (maxX + 1  - minX) * (maxY + 1 - minY);

        System.out.print(area);
        else
            area = (maxX + 1  - minX) * (maxY + 1 - minY);

        System.out.print(area);
    }
}
