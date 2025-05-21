import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

       
        int[] answer = new int[n];

        for(int i = 0; i < n; i++)
            answer[i] = Integer.parseInt(st.nextToken());


        int maxProfit = 0;

        int min = answer[0];

        for(int i = 0; i < n; i++){
            int profit = answer[i] - min;

            if(profit > maxProfit)
                maxProfit = profit;
            
            if(min > answer[i])
                min = answer[i];
            
        }
       
        System.out.print(maxProfit);
    }
}