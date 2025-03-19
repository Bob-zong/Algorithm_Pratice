import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int[] ta = new int[n];
        int[] tb = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ta[i] = Integer.parseInt(st.nextToken());
            tb[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = 0;

        for(int i = 0; i < 1000; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                if(i < ta[j])
                    sum += c;
                else if(i >= ta[j] && i <= tb[j])
                    sum += g;
                else if(i > tb[j])
                    sum += h;
            }

            ans = Math.max(sum, ans);
        }

        System.out.print(ans);
    }
}