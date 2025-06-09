import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {
    // A + B = -(C + D)
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> m1 = new HashMap<>();
        HashMap<Integer, Integer> m2 = new HashMap<>();
        
        int[][] value = new int[4][n];

        for(int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                value[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                int num = value[0][i] + value[1][j];
                
                m1.put(num, m1.getOrDefault(num, 0) + 1);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                int num = value[2][i] + value[3][j];
                
                m2.put(num, m2.getOrDefault(num, 0) + 1);
            }
        }

        Iterator<Entry<Integer, Integer>> it1 = m1.entrySet().iterator();
        Iterator<Entry<Integer, Integer>> it2 = m2.entrySet().iterator();

        int ans = 0;

        while(it1.hasNext()) {
            Entry<Integer, Integer> entry = it1.next();

            int num = entry.getKey();

            if(m2.containsKey(-num))
                ans += (entry.getValue() * m2.get(-num));
        }

        System.out.print(ans);
    }
}