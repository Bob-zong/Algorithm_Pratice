import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] answer;

    public static final int MAXNUM = 10000;
    
    public static int getCost(int minNum) {
        int low = minNum;
        int high = minNum + k;
        int cost = 0;

        for(int i = 0; i < n; i++){
            if(answer[i] < low){
                cost += (low - answer[i]);
            }
            if(answer[i] > high)
                cost += (answer[i] - high);
        }

        return cost;
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        answer = new int[n];

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        int minCost = Integer.MAX_VALUE;

        for(int i = 1; i <= MAXNUM; i++) {
            minCost = Math.min(minCost, getCost(i));
        }

        System.out.print(minCost);
        
    }
}