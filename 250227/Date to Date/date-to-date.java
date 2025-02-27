import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1, d1, m2, d2;

        //                                1.  2.  3.  4.  5.  6.  7.  8.  9. 10. 11. 12.
        int[] num_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        m1 = Integer.parseInt(st.nextToken());
        d1 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
        d2 = Integer.parseInt(st.nextToken());

        int cnt = 1;

        while(true){
            if(m1 == m2 && d1 == d2)
                break;

            d1 += 1;
            cnt += 1;

            if(d1 > num_of_days[m1]){
                m1 += 1;
                d1 = 1;
            }
        }

        System.out.print(cnt);
    }
}