import java.util.*;
import java.io.*;

public class Main {
    public static int MAXVALUE = Integer.MAX_VALUE;
    public static int MINVALUE = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int xArr[] = new int[n];
        int yArr[] = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            xArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }

        int area = 0;
        int ans = MAXVALUE;

        for(int i = 0; i < n; i++){
            int minX = MAXVALUE, minY = MAXVALUE, maxX = MINVALUE, maxY = MINVALUE;

            for(int j = 0; j < n; j++){
                if(i == j)
                    continue;
                minX = Math.min(minX, xArr[j]);
                minY = Math.min(minY, yArr[j]);
                maxX = Math.max(maxX, xArr[j]);
                maxY = Math.max(maxY, yArr[j]);
            }
            area = (maxX - minX) * (maxY - minY);
            // System.out.printf("maxX: %d minX: %d maxY: %d minY: %d", maxX, minX, maxY,minY);
            // System.out.println("area: " + area);
            ans = Math.min(ans, area);
        }

        System.out.print(area);
    }
}