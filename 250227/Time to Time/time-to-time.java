import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour1, min1, hour2, min2;

        hour1 = Integer.parseInt(st.nextToken());
        min1 = Integer.parseInt(st.nextToken());
        hour2 = Integer.parseInt(st.nextToken());
        min2 = Integer.parseInt(st.nextToken());
        
        int cnt = 0;

        while(!(hour1 == hour2 && min1 == min2)){
            
            min1 += 1;
            cnt += 1;

            if(min1 == 60){
                hour1 += 1;
                min1 = 0;
            }
        }

        System.out.print(cnt);
    }
}