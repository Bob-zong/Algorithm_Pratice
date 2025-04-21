import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;

    public static int[] x;
    public static int[] y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        x = new int[m];
        y = new int[m];

        int ans = 0;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }    


        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j)
                    continue;
                int samePair = 0;

                for(int k = 0; k < m; k++){
                    if((x[k] == i && y[k] == j) || (x[k] == j && y[k] == i))
                        samePair += 1;
                }

                ans = Math.max(samePair, ans);
            }
        }

        System.out.print(ans);
        

    }
}