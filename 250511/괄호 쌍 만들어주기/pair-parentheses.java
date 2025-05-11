import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int len = str.length();
        char[] answer = str.toCharArray();
        int[] R = new int[len];

        int cnt = 0;
        
        for(int i = len-2; i >= 0; i--) {
            if(answer[i] == ')' && answer[i+1] == ')')
                cnt += 1;

            R[i] = cnt;    
        }

        int ans = 0;

        for(int i = 1; i < len; i++){
            if(answer[i] == '(' && answer[i-1] == '(')
                ans += R[i];
        }
        
        System.out.print(ans);

        
    }
}