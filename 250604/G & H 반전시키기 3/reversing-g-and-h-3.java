import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        String originStr = br.readLine();
        String targetStr = br.readLine();

        int ans = 0;

        boolean mismatched = false;
        
        int cnt = 0;

        for(int i = 0; i < n; i++){

            if(originStr.charAt(i) != targetStr.charAt(i)) {
                
                if(!mismatched || cnt >= 4){
                    mismatched = true;
                    ans++;
                    cnt = 1;
                }
                else cnt++;

            }
            else{
                mismatched = false;
                cnt = 0;
            }
                
        }
        

        System.out.print(ans);
    }
}