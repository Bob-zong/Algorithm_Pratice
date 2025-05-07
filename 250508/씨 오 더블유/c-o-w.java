import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] L = new int[n];
        int[] R = new int[n];
        char[] answer = new char[n];

        

        for(int i = 0; i < n; i++)
            answer[i] = str.charAt(i);

        if(answer[0] == 'C')
            L[0] = 1;
        
        if(answer[n-1] == 'W')
            R[n-1] = 1;

        for(int i = 1; i < n; i++){
            if(answer[i] == 'C')
                L[i] = L[i-1] + 1;
            else L[i] = L[i-1];
        }

        for(int i = n-2; i >= 0; i--){
            if(answer[i] == 'W')
                R[i] = R[i+1] + 1;
            else R[i] = R[i+1];
        }
        long ans = 0;
        // for(int i : L)
        //     System.out.print(i);
        
        // System.out.println();
        // for(int i : R)
        //     System.out.print(i);

        for(int i = 1; i < n; i++){
            if(answer[i] == 'O'){
                ans += L[i-1] * R[i+1];
            }
        }

        System.out.print(ans);
        
    }
}