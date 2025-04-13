import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] x1;
    public static int[] x2;

    public static boolean check(int i, int j, int k) {
        int[] counting = new int[101];

        for(int idx = 0; idx < n; idx++){
            if(idx == i || idx == j || idx == k)
                continue;

            for(int x = x1[idx]; x <= x2[idx]; x++){
                counting[x] += 1;
            } 
            
        }

        for(int idx = 0; idx <= 100; idx++){
            if(counting[idx] > 1)
                return false;
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        x1 = new int[n];
        x2 = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x1[i] = Integer.parseInt(st.nextToken());
            x2[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    if(i == j || j == k || k == i)
                        continue;
                    
                    if(check(i,j,k)){
                        cnt += 1;
                    }
                }
            }
        }

        System.out.print(cnt);
        

    }
}