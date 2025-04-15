import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int minDiff = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            answer[i] *= 2;

            for(int j = 0; j < n; j++){
                int diffSum = 0;
                for(int k = 1; k < n; k++){
                    if(j == k)
                        continue;
                    
                    diffSum += Math.abs(answer[k] - answer[k-1]);
                }
                minDiff = Math.min(diffSum, minDiff);
            }
            answer[i] /= 2;

        }


        System.out.print(minDiff);
    }
}