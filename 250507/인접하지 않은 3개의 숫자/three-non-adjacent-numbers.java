import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] answer = new int[n];
        int[] L = new int[n+1];
        int[] R = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        L[0] = answer[0];
        for(int i = 1; i < n; i++)
            L[i] = Math.max(L[i-1], answer[i]);
        R[n-1] = answer[n-1];
        for(int i = n-2; i >= 0; i--)
            R[i] = Math.max(R[i+1], answer[i]);
        
        int ans = 0;

        for(int i=2; i < n-2; i++)
            ans = Math.max(ans, (L[i-2] + answer[i] + R[i+2]));

        System.out.print(ans);
    }
}