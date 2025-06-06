import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int cnt = 0;
        
        int len = str.length();

        for(int i = 0; i < len-2; i++){
            for(int j = i+1; j < len-1; j++){
                for(int k = j+1; k < len; k++){
                    if(str.charAt(i) == 'C' && str.charAt(j) == 'O' && str.charAt(k) == 'W')
                        cnt += 1;
                }
            }
        }

        System.out.print(cnt);
    }
}