import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new HashMap<>();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cnt = 0;

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(i, num);
        }

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                int num1 = map.get(i);
                int num2 = map.get(j);
                if(num1 + num2 == k){
                    cnt += 1;
                }
            }
        }

        System.out.print(cnt);


    }
}