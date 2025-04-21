import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int[] answer = new int[n+1];

        for(int i = 1; i <= n; i++){
            answer[i] = (str.charAt(i-1)) - '0';
        }

        int ans = 0;

        for(int i = 1; i <= n; i++){
            if(answer[i] == 1)
                continue;
            
            answer[i] = 1;
            int minLen = Integer.MAX_VALUE;
            for(int j = 1; j <= n; j++){
                if(answer[j] == 1){
                    int len = 0;
                    for(int k = j+1; k <= n; k++){
                        if(answer[k] == 1){
                            len = k - j;
                            break;
                        }
                    }
                    if(len != 0)
                        minLen = Math.min(len, minLen);

                }
            }
            answer[i] = 0;
            ans = Math.max(minLen,ans);
        }
        System.out.print(ans);
    }
}