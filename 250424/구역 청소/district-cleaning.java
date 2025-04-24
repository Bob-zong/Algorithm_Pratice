import java.util.*;
import java.io.*;

public class Main {
    public static int a, b, c, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int len = 0;

        int[] ans = new int[1000];

        for(int i = a; i < b; i++)
            ans[i] += 1;

        for(int i = c; i < d; i++)
            ans[i] += 1;

        for(int i = 0; i < 100; i++){
            if(ans[i] != 0)
                len += 1;
        }
            
        
        System.out.print(len);


    }
}