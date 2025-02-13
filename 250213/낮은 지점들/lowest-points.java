import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(map.containsKey(x)){
                if(map.get(x) > y)
                    map.put(x, y);
            }else{
                map.put(x, y);
            }
        }
        int sum = 0;

        for(int key : map.keySet()){
            sum += map.get(key);
        }
        System.out.print(sum);
    }
}