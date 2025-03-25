import java.util.*;
import java.io.*;

public class Main {
    public static boolean checkNum(int num){
        boolean condition = false;
        int countArr[] = new int[10];

        while(num > 0){
            int digit = num % 10;
            num /= 10;
            countArr[digit] += 1;
        }
        int cnt = 0;
        int numCnt = 0;

        for(int i = 0; i < countArr.length; i++){
            if(countArr[i] > 0)
                numCnt += 1;

            if(countArr[i] == 1)
                cnt+= 1;
        }

        if(cnt == 1 && numCnt == 2)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start, end;
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        int cnt = 0;

        for(int i = start; i <= end; i++){
            if(checkNum(i)){
                cnt+= 1;
                // System.out.println("num: " + i);
            }
                
        }

        System.out.print(cnt);

    }
}