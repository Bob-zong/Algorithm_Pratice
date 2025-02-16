import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] Token = new int[n];

        for(int i = 0; i < n; i++)
            Token[i] = Integer.parseInt(br.readLine());

        
        Integer[] tmp = Arrays.stream(Token).boxed().toArray(Integer[]::new);
        
        Arrays.sort(tmp, Collections.reverseOrder());

        int cnt = 0;
        int cost = k;
        int i = 0;
        while(cost != 0){
                cnt += cost / tmp[i];
                cost = cost % tmp[i];
                i++;
        }

        System.out.print(cnt);    
    }
}