import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> s = new TreeSet<>();

        int n = Integer.parseInt(br.readLine());

        int[] B = new int[n];
        int[] A = new int[n];

        for(int i = 1; i <= 2*n; i++){
            s.add(i);
        }

        for(int i = 0; i < n; i++){
            B[i] = Integer.parseInt(br.readLine());
            s.remove(B[i]);
        }
        

        int ans = 0;

        for(int i = 0; i < n; i++){
            if(s.higher(B[i]) != null){
                ans++;
                s.remove(s.higher(B[i]));
            }
        }

        System.out.print(ans);

        
    }
}