import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] R = new int[n];
        HashMap<Integer, Integer> latestIndex = new HashMap<>(); 

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for(int i = n - 1; i >= 0; i--) {
            if(!latestIndex.containsKey(arr[i]))
                R[i] = -1;
            else
                R[i] = latestIndex.get(arr[i]);
            
            latestIndex.put(arr[i], i);
        }

        int ans = -1;

        for(int i = 0; i < n; i++) {
            if(R[i] != -1 && R[i] - i <= k)
                ans = Math.max(ans, arr[i]);
        }

        System.out.print(ans);
        // HashMap<Integer, ArrayList>
        // 
    }
}