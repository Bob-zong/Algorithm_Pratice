import java.util.*;
import java.io.*;

public class Main {
    public static int n, sumValue;
    public static int[] answer;

    public static int getDiff(int x, int y) {
        int sum1 = answer[x] + answer[y];
        int sum2 = 0;
        int sum3 = 0;
        int mintemp = Integer.MAX_VALUE;

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(i == x || i == y || j == x || j == y)
                    continue;

                sum2 = answer[i] + answer[j];
                sum3 = sumValue - sum1 - sum2;
                int[] sumArr = new int[]{sum1,sum2,sum3};
                Arrays.sort(sumArr);
                mintemp = Math.min(mintemp, sumArr[2]- sumArr[0]);              
            }
        }

        return mintemp;
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int minValue = Integer.MAX_VALUE;

        n = 6;
        answer = new int[n];

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

        System.out.print(minValue);

    }
}