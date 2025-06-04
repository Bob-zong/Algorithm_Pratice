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
                cnt++;
                if(!mismatched){
                    mismatched = true;
                    ans++;
                }
            }
            else{
                mismatched = false;
                ans += cnt / 4;
                cnt = 0;
            }
                
        }
        

        System.out.print(ans);
    }
}