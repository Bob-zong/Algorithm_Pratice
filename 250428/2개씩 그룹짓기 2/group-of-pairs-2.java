import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        int[] answer = new int[2*n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 2*n; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        // 2 5 7 9 10 15
        Arrays.sort(answer);
        int minNum = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            minNum = Math.min(minNum, answer[i+n] - answer[i]);
        }
        System.out.print(minNum);
        
    }
}