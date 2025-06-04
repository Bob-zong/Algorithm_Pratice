import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        String originStr = br.readLine();
        String targetStr = br.readLine();
        
        char[] origin = originStr.toCharArray();
        char[] target = targetStr.toCharArray();


        
        int j = 0;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            int idx = 0;
            
            while((origin[j] != target[j]) && idx < 4 && j < n){
                j++;
                idx++;
            }

            if(idx != 0)
                ans++;
            if(j > i)
                i = j;
        }

        System.out.print(ans);
    }
}