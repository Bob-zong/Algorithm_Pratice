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


        int cnt = 0;

        if(answer[2] == (answer[1] + 1) && (answer[1] == answer[0] + 1))
            cnt = 0;
        else if(answer[2] - answer[1] == 2 || answer[1] - answer[0] == 2)
            cnt = 1;
        else if(answer[2] - answer[1] > 2 || answer[1] - answer[0] > 2)
            cnt = 2;
        


        System.out.print(cnt);
    }
}