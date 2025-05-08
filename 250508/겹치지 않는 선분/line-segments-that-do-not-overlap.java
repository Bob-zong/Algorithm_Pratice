import java.util.*;
import java.io.*;

class Segment implements Comparable<Segment> {
    int x1, x2;
    public Segment(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Segment s) {
        return this.x1 - s.x1;
    }
}
public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_X = 1000000;
    public static int n;
    public static Segment[] answer = new Segment[MAX_N];
    public static int[] L = new int[MAX_N];
    public static int[] R = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            answer[i] = new Segment(x1, x2);
        }

        Arrays.sort(answer, 0, n);

        L[0] = answer[0].x2;
        for(int i = 1; i < n; i++){
            L[i] = Math.max(L[i-1], answer[i].x2);
        }

        R[n-1] = answer[n-1].x2;
        for(int i = n-2; i >= 0; i--){
            R[i] = Math.min(R[i+1], answer[i].x2);
        }

        int ans = 0;

        for(int i = 0; i < n; i++){
            if(i > 0 && L[i-1] >= answer[i].x2)
                continue;
            if(i < n-1 && R[i+1] <= answer[i].x2)
                continue;
            
            ans++;
        }

        System.out.print(ans);


    }
}