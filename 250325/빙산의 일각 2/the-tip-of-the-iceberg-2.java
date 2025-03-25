import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer[] = new int[n];

        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;

        for(int i = 1; i <= 1000; i++){
            int cnt = 0;
            boolean condition = false;

            for(int j = 0; j < n; j++){
                if(answer[j] > i && condition == false){
                    condition = true;
                    // System.out.print("높이: " + i);
                    // System.out.println(" idx: " + j);
                    cnt += 1;           
                }else if(answer[j] <= i){
                    condition = false;
                }
                   
            }

            ans = Math.max(cnt, ans);
        }

        System.out.print(ans);
    }
}