import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] top = new int[n];
        int[] bottom = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            top[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            bottom[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < t; i++){
            int topTemp = top[n-1];
            int botTemp = bottom[n-1];

            for(int j = n-1; j > 0; j--){
                top[j] = top[j-1];
            }

            top[0] = botTemp;
            for(int k = n-1; k > 0; k--){
                bottom[k] = bottom[k-1];
            }
            bottom[0] = topTemp;
        }

        for(int i = 0; i < n; i++){
            sb.append(top[i]).append(" ");
        }
        sb.append("\n");
        for(int i = 0; i < n; i++){
            sb.append(bottom[i]).append(" ");
        }

        System.out.print(sb);
        
    }
}