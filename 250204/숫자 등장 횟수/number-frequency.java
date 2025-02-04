import java.util.*;
import java.io.*;

public class Main {
    public static Map<Integer, Integer> map = new HashMap<>();
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int num = Integer.parseInt(st.nextToken());
            // arr[i] += 1;
            map.put(num, i);
        }
        
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!map.containsKey(map.get(num))){
                System.out.print("0 ");
            }
            else{
                System.out.print(map.get(num) + " ");
            }
        }
        
    }
}