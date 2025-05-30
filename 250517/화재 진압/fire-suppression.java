import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> s = new TreeSet<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] firePos = new int[n];
        int[] stationPos = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            firePos[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            stationPos[i] = Integer.parseInt(st.nextToken());
            s.add(stationPos[i]);
        }

        long ans = 0;

        for(int i = 0; i < n; i++) {
            Integer x1 = s.ceiling(firePos[i]);
            Integer x2 = s.floor(firePos[i]);
            long nearDist = Long.MAX_VALUE;

            if(x1 != null)
                nearDist = Math.min(nearDist, Math.abs(firePos[i] - x1));
            if(x2 != null)
                nearDist = Math.min(nearDist, Math.abs(firePos[i] - x2));

            ans = Math.max(ans, nearDist);
        }

        System.out.print(ans);
    }
}
