import java.util.*;
import java.io.*;

public class Main {
    public static int[] xArr, yArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        xArr = new int[n];
        yArr = new int[n];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            xArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = Integer.MAX_VALUE;

        for(int i = 1; i < n-1; i++){
            int dist = 0;
            int tmpX = xArr[i];
            int tmpY = yArr[i];

            xArr[i] = xArr[i-1];
            yArr[i] = yArr[i-1];

            for(int j = 1; j < n; j++){
                dist += Math.abs(xArr[j] - xArr[j-1]) + Math.abs(yArr[j] - yArr[j-1]);
            }

            ans = Math.min(dist, ans);

            xArr[i] = tmpX;
            yArr[i] = tmpY;
        }

        System.out.print(ans);

    }
}