import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int secondMinNum = Integer.MAX_VALUE;
        int minNum = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            minNum = Math.min(minNum, answer[i]);
        }
        int secondminIdx = 0;

        for(int i = 1; i <= n; i++){
            if(secondMinNum > answer[i] && answer[i] != minNum){
                secondMinNum = answer[i];
                secondminIdx = i;
            }
        }
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(answer[i] == secondMinNum){
                cnt +=1;
            }
        }

        if(cnt == 1){
            System.out.print(secondminIdx);
        }
        else{
            System.out.print(-1);
        }

    }
}