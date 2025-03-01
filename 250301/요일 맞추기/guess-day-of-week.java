import java.util.*;
import java.io.*;

public class Main {
    public static String[] day = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    public static int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int numOfDays(int m, int d) {
        int totalDays = 0;
       
        for(int i = 1; i < m; i++)
            totalDays += days[i];
        
        totalDays += d;
        
        return totalDays;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        
        int diff = numOfDays(m2, d2) - numOfDays(m1, d1);
        
        while(diff < 0)
            diff += 7;
        System.out.print(day[diff % 7]);
    }
}