import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] answer;
    public static boolean isPossible(int minVal) {
        int []availableIndices = new int[n];
        int cnt = 0;

        for(int i = 0; i < n; i++)
            if(answer[i] >= minVal)
                availableIndices[cnt++] = i;

        for(int i = 1; i < cnt; i++) {
            int dist = availableIndices[i] - availableIndices[i - 1];
            if(dist > k)
                return false;
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        answer = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        int maximin = 0;
        
        for(int a = 0; a < n; a++){
            if(isPossible(a))
                maximin = Math.max(maximin,a);
        }

        System.out.print(maximin);
        
    }
}