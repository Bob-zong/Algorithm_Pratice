import java.util.*;
import java.io.*;

public class Main {
    public static int[] xArr, yArr;
    public static int[] L;
    public static int[] R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        xArr = new int[n];
        yArr = new int[n];
        L = new int[n];
        R = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            xArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i < n; i++){
            L[i] = L[i-1] + Math.abs(xArr[i] - xArr[i-1]) + Math.abs(yArr[i] - yArr[i-1]);
        }

        for(int i = n-2; i >= 0; i--)
            R[i] = R[i + 1] + Math.abs(xArr[i] - xArr[i+1]) + Math.abs(yArr[i] - yArr[i+1]);
        

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i < n-1; i++){
            // i번째 숫자를 제외했을 때 답
            int value = L[i-1] + R[i+1] + Math.abs(xArr[i+1] - xArr[i-1]) + Math.abs(yArr[i+1] - yArr[i-1]);
            ans = Math.min(ans, value);
        }

        System.out.print(ans);

    }
}