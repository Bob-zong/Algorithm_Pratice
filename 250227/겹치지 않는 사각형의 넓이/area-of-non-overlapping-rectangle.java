import java.util.*;
import java.io.*;

public class Main {
    static final int OFFSET = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] answer = new int[2001][2001];
        int cnt = 0;

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            int x1, y1, x2, y2;

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            x1 += OFFSET;
            y1 += OFFSET;
            x2 += OFFSET;
            y2 += OFFSET;

            for(int x = x1; x < x2; x++){
                for(int y = y1; y < y2; y++){
                    if(i < 2)
                        answer[x][y] = 1;
                    else
                        answer[x][y] = 0;
                }
            }

        }

        for(int i = 0; i < 2001; i++){
            for(int j = 0; j < 2001; j++){
                if(answer[i][j] == 1)
                    cnt += 1;
            }
        }
        System.out.print(cnt);
    }
}