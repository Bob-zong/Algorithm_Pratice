import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] answer;
    public static int maxDist;

    public static int getMaxDist() {
        int minDist = n;

        for(int i = 0; i < n; i++){
            if(answer[i] == 1){
                for(int j = i+1; j < n; j++){
                    if(answer[j] == 1)
                        minDist = Math.min(minDist, j - i);
                }
            }
        }

        return minDist;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String num = br.readLine();
        int len = num.length();
        
        answer = new int[len];

        for(int i = 0; i < len; i++)
            answer[i] = Character.getNumericValue(num.charAt(i));


        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                if(answer[i] == 0 && answer[j] == 0){
                    answer[i] = 1;
                    answer[j] = 1;
                    maxDist = Math.max(maxDist,getMaxDist());

                    answer[i] = 0;
                    answer[j] = 0;
                }
            }
        }

        System.out.print(maxDist);

    }
}