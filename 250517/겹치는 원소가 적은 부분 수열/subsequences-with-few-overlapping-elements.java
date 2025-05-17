import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] answer;
    public static HashMap<Integer, Integer> m = new HashMap<>();

    public static boolean canMove(int j) {
        if(j + 1 > n)
            return false;
        
        if(m.getOrDefault(answer[j+1], 0) == k)
            return false;
        
        return true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        answer = new int[n+1];

        st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= n; i++)
            answer[i] = Integer.parseInt(st.nextToken());
        
        int ans = 0;

        int j = 0;

        for(int i = 1; i <= n; i++) {

            while(canMove(j)) {
                m.put(answer[j+1], m.getOrDefault(answer[j+1], 0) + 1);
                j++;
            }

            ans = Math.max(ans, j-i+1);
            // 삭제

            m.put(answer[i], m.get(answer[i]) - 1);
            
        }

        System.out.print(ans);

    }
}