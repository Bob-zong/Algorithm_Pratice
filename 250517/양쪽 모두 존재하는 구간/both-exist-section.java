import java.util.*;
import java.io.*;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;

    public static int n, m;
    public static int ans;
    public static int[] answer;
    public static HashMap<Integer, Integer> inMap = new HashMap<>();
    public static HashMap<Integer, Integer> outMap = new HashMap<>();

    // public static boolean canMove(int j) {
    //     if(j+1 > n)
    //         return false;

    //     if(outMap.getOrDefault(answer[j+1], 0) < 2)
    //         return false;
        
    //     return true;
    // }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = INT_MAX;

        answer = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
            outMap.put(answer[i], outMap.getOrDefault(answer[i], 0) + 1);
        }

        int j = 0;

        for(int i = 1; i <= n; i++) {

            while(j+1 < n && inMap.size() < m) {
                inMap.put(answer[j+1], inMap.getOrDefault(answer[j+1], 0) + 1);
                outMap.put(answer[j+1], outMap.getOrDefault(answer[j+1], 0) - 1);
                if(outMap.getOrDefault(answer[j+1], 0) <= 0)
                    outMap.remove(answer[j+1]);
                
                j++;
            }

            if(inMap.size() == m && outMap.size() == m){
                ans = Math.min(ans, j - i + 1);
                // System.out.println(j + " " + i);
            }

                
            inMap.put(answer[i], inMap.getOrDefault(answer[i], 0) - 1);
            outMap.put(answer[i], outMap.getOrDefault(answer[i], 0) + 1);
            
            if(inMap.getOrDefault(answer[i], 0) <= 0)
                inMap.remove(answer[i]);
            
        }

        if(ans == INT_MAX)
            System.out.print(-1);
        else
            System.out.print(ans);

    }
}

