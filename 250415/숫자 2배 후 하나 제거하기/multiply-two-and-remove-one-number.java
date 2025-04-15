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
                int[] newArray = new int[n-1];
                int idx = 0;
                int sumDiff = 0;

                for(int k = 0; k < n; k++){
                    if(k == j)
                        continue;

                    newArray[idx++] = answer[k];
                }


                for(int k = 0; k < n - 2; k++){
                    sumDiff += Math.abs(newArray[k+1] - newArray[k]);
                } 
            minDiff = Math.min(minDiff,sumDiff);

            }

            answer[i] /= 2;

        }


        System.out.print(minDiff);
    }
}