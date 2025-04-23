import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_A = 10000;
    
    public static int n, m;
    public static int[] a = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n];
        
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int ans = MAX_A;

        for(int i = 1; i <= MAX_A; i++){
            boolean possible = true;
            int section = 1;

            int cnt = 0;

            for(int j = 0; j < n; j++){
                if(a[j] > i) {
                    possible = false;
                    break;
                }

                if(cnt + a[j] > i) {
                    cnt = 0;
                    section += 1;
                }

                cnt += a[j];
            }

            if(possible && section <= m){
                ans = Math.min(ans, i);
            }
        }

        System.out.print(ans);


    }
}