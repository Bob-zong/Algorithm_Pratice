import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int answer[] = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int dist = 0;

            for(int j = 0; j < n; j++){
                dist += Math.abs((answer[j]) * (j - i));
            }

            min = Math.min(dist, min);
        }

        System.out.print(min);
        
        
    }
}