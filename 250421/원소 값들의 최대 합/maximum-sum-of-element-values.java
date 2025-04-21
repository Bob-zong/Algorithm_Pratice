import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        answer = new int[n+1];

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int Maxsum = 0;
        
        for(int i = 1; i <= n; i++){
            int sum = 0;
            int currIdx = i;

            for(int j = 0; j < m; j++){
                int currValue = answer[currIdx];
                currIdx = currValue;
                sum += currValue;
            }

            Maxsum = Math.max(sum, Maxsum);
        }
        // for(int i = 1; i <= n - m + 1; i++) {
        //     int sum = 0;

        //     for(int j = i; j < i + m; j++){
        //         if(answer[j] != j){
        //             int temp = answer[j];
                    
        //             for(int k = 1; k <= n; k++){
        //                 if(answer[k] == j){
        //                     answer[j] = answer[k];
        //                     answer[k] = temp;
        //                 }
                            
        //             }
                    
        //             sum += temp;
        //         }
        //     }
        //     Maxsum = Math.max(sum, Maxsum);
        // }

        System.out.print(Maxsum);
    }
}