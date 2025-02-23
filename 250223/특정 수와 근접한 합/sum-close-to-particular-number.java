import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s , n;
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int[] answer = new int[n];
        st = new StringTokenizer(br.readLine());
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
            sum += answer[i];
        }
        int diff = Integer.MAX_VALUE;

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                 int ans = answer[i] + answer[j];
                diff = Math.min(diff, Math.abs(s - (sum-ans)));    
            }
        }
        System.out.print(diff);
    }
}