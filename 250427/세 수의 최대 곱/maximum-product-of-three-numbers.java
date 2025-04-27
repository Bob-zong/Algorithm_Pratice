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

        // case1 모두 양수
        // case2 음수 2, 양수 1
        // case3 0인 경우

        Arrays.sort(answer);

        // case3
        int maxValue = Integer.MIN_VALUE;
        
        if(answer[n-1] == 0 || answer[n-2] == 0 || answer[n-3] == 0)
            maxValue = 0;
        else if(answer[0] > 0){
            maxValue = answer[n-1] * answer[n-2] * answer[n-3];
        }
        else{
            int value1 = answer[0] * answer[1] * answer[n-1];
            int value2 = answer[n-1] * answer[n-2] * answer[n-3];
            maxValue = Math.max(value1, value2);
        }
        System.out.print(maxValue);
        // case1



    }
}