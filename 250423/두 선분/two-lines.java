import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1, x2, x3, x4;

        x1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        x3 = Integer.parseInt(st.nextToken());
        x4 = Integer.parseInt(st.nextToken());

        boolean condition = false;

        int sec1 = Math.max(x1, x2);
        int sec2 = Math.max(x3, x4);
        
        if(sec1 > sec2)
            if(x1 <= x4)
            condition = true;
        // x1 ~ x2가 더 큰 경우
        if(sec2 > sec1)
            if(x3 <= x2)
            condition = true;
        // x3 ~ x4가 더 큰 경우
        
        if(condition)
            System.out.print("intersecting");
        else
            System.out.print("nonintersecting");
        
    }
}