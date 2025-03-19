import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();

        int ans = 0;

        for(int i = 0; i < str.length(); i++){
            char ch1 = str.charAt(i);
            if(ch1 == ')')
                continue;

            for(int j = i + 1; j < str.length(); j++){
                char ch2 = str.charAt(j);
                if(ch2 == ')')
                    ans += 1;
            }
        }

        System.out.print(ans);

    }
}