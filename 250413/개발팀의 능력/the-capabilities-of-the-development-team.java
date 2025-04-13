import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] answer;
    public static int sumValue, minValue;

    public static final int MAXVALUE = Integer.MAX_VALUE;

    public static int getDiff(int num1, int num2) {
        int sum1 = answer[num1] + answer[num2];
        int sum2 = 0;
        int sum3 = 0;
        int mintemp = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(i == num1 || i == num2 || j == num1 || j == num2){
                    continue;
                }

                sum2 = answer[i] + answer[j];
                sum3 = sumValue - sum1 - sum2;
                if(sum1 == sum2 || sum2 == sum3 || sum3 == sum1)
                    continue;
                
                int[] sumArr = new int[]{sum1, sum2, sum3};
                Arrays.sort(sumArr);
                mintemp = Math.min(mintemp,sumArr[2] - sumArr[0]);
            }
        }

        return mintemp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = 5;
        answer = new int[n];
        minValue = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        sumValue = 0;
        for(int i = 0; i < n; i++){
            sumValue += answer[i];
        }

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int diff = getDiff(i, j);
                minValue = Math.min(minValue, diff);
            }    
        }
        if(minValue == MAXVALUE)
            System.out.print("-1");
        else
            System.out.print(minValue);
    }
}