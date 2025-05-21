import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());


        int ans = -1;

        int fiveCnt = 0;
        int twoCnt = 0;
        int remain = 0;

        fiveCnt = n / 5;
        remain = n % 5;
// 22 24 26 28
// 21 23 27 29
        if(remain % 2 != 0 && remain < 5) {
            if(fiveCnt != 0)
                fiveCnt--;
            
            twoCnt = (n - (5 * fiveCnt)) / 2;
        }
        else if(remain % 2 == 0 && remain > 5){
            if(fiveCnt != 0)
                fiveCnt--;
            
            twoCnt = (n - (5 * fiveCnt)) / 2;
        }
        else{
            twoCnt = remain / 2;
        }

        System.out.print(fiveCnt + twoCnt);



        
    }
}