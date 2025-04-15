import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for(int i = start; i <= end; i++){
            String str = String.valueOf(i);
            int len = str.length();

            boolean condition = true;

            for(int j = 0; j < len; j++){
                if(str.charAt(j) != str.charAt(len-1-j))
                    condition = false;
            }

            if(condition)
                cnt += 1;
        }

        System.out.print(cnt);
    }
}