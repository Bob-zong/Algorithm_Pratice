import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());
        int[] answer = new int[]{num1, num2, num3};
        Arrays.sort(answer);

        boolean condition = false;
        int cnt = 0;

        if(answer[1] == (answer[0]+1) && answer[1] == (answer[2]-1)){
                condition = true;
        }
        
        while(!condition) {
            int temp = (answer[1] + answer[2]) / 2;
            answer[0] = temp;
            cnt += 1;
            Arrays.sort(answer);
            
            if(answer[1] == (answer[0]+1) && answer[1] == (answer[2]-1)){
                condition = true;
            }
        }

        System.out.print(cnt);
    }
}