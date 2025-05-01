import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> plusPQ = new PriorityQueue<>();
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                int plus;
                int minus;
                
                if(plusPQ.size() == 0 && minusPQ.size() == 0){
                    sb.append(0).append("\n");
                    continue;
                }
                    
                else if(plusPQ.size() == 0){
                    plus = Integer.MAX_VALUE;
                    minus = minusPQ.peek();
                }      
                else if(minusPQ.size() == 0){
                    minus = Integer.MAX_VALUE;
                    plus = plusPQ.peek();
                }
                else{
                    plus = plusPQ.peek();
                    minus = minusPQ.peek();
                }
                    

                if(plus < minus){
                    sb.append(plusPQ.poll()).append("\n");
                }
                else
                    sb.append(-minusPQ.poll()).append("\n");
            }
            else if(num > 0){
                plusPQ.add(num);
            }
            else{
                minusPQ.add(-num);
            }
        }

        System.out.print(sb);
    }
}