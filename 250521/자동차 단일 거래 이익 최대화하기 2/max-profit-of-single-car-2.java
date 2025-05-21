import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] L = new int[n+1];
        int[] R = new int[n+1];

        int[] answer = new int[n+1];

        for(int i = 1; i <= n; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        L[0] = answer[1];
        for(int i = 1; i <= n; i++)
            L[i] = Math.min(L[i-1], answer[i]);

        R[n] = answer[n];
        for(int i = n-1; i >= 1; i--)
            R[i] = Math.max(R[i+1], answer[i]);


        int ans = 0;

        for(int i = 0; i < n; i++){
            ans = Math.max(ans, R[i+1] - L[i]);
        }         
        
        // for(int i : L)
        //     System.out.print(i + " ");
        
        // System.out.println();

        // for(int i : R)
        //     System.out.print(i + " ");
        System.out.print(ans);
    }
}