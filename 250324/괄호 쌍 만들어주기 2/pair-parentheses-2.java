import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int cnt = 0;

        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == '(' && str.charAt(i+1) == '(')
                for(int j = i+2; j < str.length()-1; j++){
                    if(str.charAt(j) == ')' && str.charAt(j+1) == ')')
                        cnt += 1;
                }
        }

        System.out.print(cnt);
    }
}