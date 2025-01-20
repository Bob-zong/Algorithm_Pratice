import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] answer = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int maxValue = 0;

        for(int i = 0; i <= n-k; i++){
            int sum = 0;
            for(int j = i; j < i + k; j++){
                sum += answer[j];
            }
            maxValue = Math.max(maxValue, sum);
        }
        
        bw.write(String.valueOf(maxValue));
        bw.flush();
        bw.close();
    }
}