import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] answer = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(br.readLine());
            sum += answer[i];
        }

        sum = sum / n;
        int ans = 0;

        for(int i = 0; i < n; i++){
            if(answer[i] > sum)
                ans += answer[i] - sum;
        }

        System.out.print(ans);

    }
}
