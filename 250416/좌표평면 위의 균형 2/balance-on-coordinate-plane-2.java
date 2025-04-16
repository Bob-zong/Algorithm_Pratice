import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static final int MAX_NUM = 100;
    public static int[] xArr;
    public static int[] yArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        xArr = new int[MAX_NUM+1];
        yArr = new int[MAX_NUM+1];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            xArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }

        int minValue = Integer.MAX_VALUE;

        for(int x = 0; x <= 100; x += 2) {
            for(int y = 0; y <= 100; y += 2) {
                // x , y 기준 1사분면
                int cnt1 = 0;
                int cnt2 = 0;
                int cnt3 = 0;
                int cnt4 = 0;

                for(int i = 0; i < n; i++){
                    if(xArr[i] > x && yArr[i] > y)
                        cnt1 += 1;
                    else if(xArr[i] > x && yArr[i] < y)
                        cnt2 += 1;
                    else if(xArr[i] < x && yArr[i] < y)
                        cnt3 += 1;
                    else if(xArr[i] < x && yArr[i] > y)
                        cnt4 += 1;
                }
                
                int[] cntArr = new int[]{cnt1, cnt2, cnt3, cnt4};
                Arrays.sort(cntArr);

                minValue = Math.min(minValue, cntArr[3]);
            }
        }

        System.out.print(minValue);

    }
}