import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int minValue = Integer.MAX_VALUE;

        int n = 6;
        int[] answer = new int[n];

        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int sumValue = 0;
        for(int i = 0; i < n; i++){
            sumValue += answer[i];
        }
        for(int i = 0; i < n-2; i++){
            for(int j = i + 1; j < n-1; j++){
                for(int k = j + 1; k < n; k++){
                    int sum = answer[i] + answer[j] + answer[k];
                    int sum1 =  Math.abs(sumValue - sum); 
                    minValue = Math.min(minValue, Math.abs(sum1 - sum));
                    
                }
            }
        }
        System.out.print(minValue);

    }
}