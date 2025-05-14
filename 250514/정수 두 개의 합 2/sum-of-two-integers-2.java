import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] answer = new int[n+1];

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(br.readLine());
            // sumVal += answer[]
        }
            

        Arrays.sort(answer);

        int j = 1;
        int ans = 0;
        int sumVal = 0;

        for(int i = 1; i <= n; i++){
            sumVal = answer[i];

            while(j+1 <= n && sumVal + answer[j+1] <= k){
                j++;
            }
            // j = 3; i = 1
            if(sumVal + answer[j] <= k)
                ans += (j - i);

            if(sumVal >= k)
                break;

            // System.out.println(ans);
            sumVal -= answer[i];
        }
        
        System.out.print(ans);
    }
}