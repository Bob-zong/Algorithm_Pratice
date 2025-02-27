import java.util.*;
import java.io.*;

public class Main {
    public static int calculate(int hour, int min, int day, int sHour, int sMin, int sDay){
        int dayDiff = (day - sDay) * 24 * 60;
        int hourDiff = (hour - sHour) * 60;
        int minDiff = min - sMin;

        int sum = dayDiff + hourDiff + minDiff;
        return sum;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(st.nextToken());
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        int s_day = 11;
        int s_hour = 11;
        int s_min = 11;


        // int cnt = 0;

        // if(s_day > day)
        //     if(s_hour > hour)
        //         if(s_min > min){
        //             System.out.print(-1);
        //             System.exit(1);
        //         }

        // while(!(s_day == day && s_hour == hour && s_min == min)){
        //     // if(s_day == day && s_hour == hour && s_min == min)
        //     //     break;

        //     s_min += 1;
        //     cnt += 1;

        //     if(s_min == 60){
        //         s_hour += 1;
        //         s_min = 0;
        //     }

        //     if(s_hour == 24){
        //         s_day += 1;
        //         s_hour = 0;
        //     }
        // }
        int ans = calculate(hour, min, day, 11 , 11, 11);
        if(ans < 0)
            System.out.print(-1);
        else
            System.out.print(ans);
    }
}