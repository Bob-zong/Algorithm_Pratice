import java.util.*;
import java.io.*;


public class Main {
    public static final int OFFSET = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer[][] = new int[2001][2001];

        for(int i = 0; i < 2; i++){
            st = new StringTokenizer(br.readLine());

            int x1, y1, x2, y2;

            x1 = Integer.parseInt(st.nextToken()) + OFFSET;
            y1 = Integer.parseInt(st.nextToken()) + OFFSET;
            x2 = Integer.parseInt(st.nextToken()) + OFFSET;
            y2 = Integer.parseInt(st.nextToken()) + OFFSET;

            for(int x = x1; x < x2; x++){
                for(int y = y1; y < y2; y++){
                    if(i == 0)
                        answer[x][y] = 1;
                    else
                        answer[x][y] = 2;
                }
            }
        }
        int xLen = 0;
        int yLen = 0;

        for(int x = 0; x < 2001; x++){
            int maxXLen = 0;
            for(int y = 0; y < 2001; y++){
              if(answer[x][y] == 1)
                maxXLen += 1;
            }
            xLen = Math.max(maxXLen, xLen); 
        }

        for(int y = 0; y < 2001; y++){
            int maxYLen = 0;
            for(int x = 0; x < 2001; x++){
              if(answer[x][y] == 1)
                maxYLen += 1;
            }
            yLen = Math.max(maxYLen, yLen); 
        }

        System.out.print(xLen * yLen);

    }
}