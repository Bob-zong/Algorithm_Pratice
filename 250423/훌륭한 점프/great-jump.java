import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_NUM = 100;

    public static int n, k;
    public static int[] answer;
    public static boolean isPossible(int limit) {
        int lastIdx = 0;

        for(int i = 1; i < n; i++)
            if(answer[i] <= limit) {
                if(i - lastIdx > k)
                    return false;
                lastIdx = i;
            }
        return true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        answer = new int[MAX_N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            answer[i] = Integer.parseInt(st.nextToken());


        for(int i = Math.max(answer[0], answer[n-1]); i <= MAX_NUM; i++){
            if(isPossible(i)) {
                System.out.print(i);
                break;
            }
        }

        
        
    }
}