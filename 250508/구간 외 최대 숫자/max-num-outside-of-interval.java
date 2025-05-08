import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100000;

    public static int n, q;
    public static int[] answer = new int[MAX_N];
    public static int[] L = new int[MAX_N];
    public static int[] R = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // TreeSet<Integer> s = new TreeSet<>();
        // HashMap<Integer, Integer> map = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();


        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
            // s.add(answer[i]);
        }
            
        // for(Integer num : s)
        //     map.put(num, cnt++);
        
        L[0] = 0;
        for(int i = 1; i < n; i++){
            L[i] = Math.max(L[i-1], answer[i]);
        }

        R[n] = answer[n];
        for(int i = n-1; i >= 0; i--)
            R[i] = Math.max(R[i+1], answer[i]);
        
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int max = Integer.MIN_VALUE;

            max = Math.max(L[x1-1], R[x2+1]);

            sb.append(max).append("\n");

        }
        System.out.print(sb);
    }
}