import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] x;
    public static int[] y;
    // public static int[] xCnt;
    // public static int[] yCnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        x = new int[n];
        y = new int[n];
        // xCnt = new int[11];
        // yCnt = new int[11];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            // xCnt[xArr[i]] += 1;
            // yCnt[yArr[i]] += 1;
        }


        int answer = -1;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                for(int k = 0; k < 11; k++){
                    boolean s = false;
                     // x만 3개
                for(int l = 0; l<n; l++){
                    if(x[l] == i || x[l] == j || x[l] == k) continue;
                    s = false;
                }
                if(s)
                    answer = 1;

                // y가 2개 x가 1개
                s = true;
                for(int l = 0; l<n; l++){
                    if(x[l] == i || y[l] == j || y[l] == k) continue;
                    s = false;
                }
                if(s)
                    answer = 1;

                // y가 1개 x가 2개
                s = true;
                for(int l = 0; l<n; l++){
                    if(x[l] == i || x[l] == j || y[l] == k) continue;
                    s = false;
                }
                if(s)
                    answer = 1;

                // y가 3개
                s = true;
                for(int l = 0; l<n; l++){
                    if(y[l] == i || y[l] == j || y[l] == k) continue;
                    s = false;
                }
                if(s)
                    answer = 1;
                }
            }
        }       

        System.out.print(answer);
    }
}