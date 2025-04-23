import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] answer;
    public static int minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        answer = new int[n];

        for(int i = 0; i < n; i++)
            answer[i] = Integer.parseInt(br.readLine());
        
        minCost = Integer.MAX_VALUE;

        // 최소 높이 0 ~ 83까지 완전 탐색 진행
        for(int i = 0; i <= 83; i++){
            int minHigh = i;
            int maxHigh = minHigh+17;
            int cost = 0;

            for(int j = 0; j < n; j++){
                if(answer[j] < minHigh){
                    int diff = minHigh - answer[j];
                    cost += diff * diff;
                }
                else if(answer[j] > maxHigh){
                    int diff = answer[j] - maxHigh;
                    cost += diff * diff;    
                }

            }

            minCost = Math.min(minCost, cost);
        }

        System.out.print(minCost);
        
  
            
    }
}  