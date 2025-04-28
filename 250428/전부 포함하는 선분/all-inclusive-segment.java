import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n];
        int[] y = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }


        int minLen = 1000;
        for(int i = 0; i < n; i++){
            int minX = 100;
            int maxX = 0;            
            for(int j = 0; j < n; j++){
                if(i == j)  continue;

                minX = Math.min(minX,x[j]);
                maxX = Math.max(maxX,y[j]);
            }
            minLen = Math.min(minLen, maxX-minX);
        }

        System.out.print(minLen);
    }
}