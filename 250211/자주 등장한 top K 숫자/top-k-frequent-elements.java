import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] numArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        numArr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
            map.put(numArr[i], map.getOrDefault(numArr[i], 0) + 1); 
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer key1, Integer key2){
                return map.get(key2).compareTo(map.get(key1));
            }
        });
        
        for(int i = k-1; i >= 0; i--){
            System.out.print(keySet.get(i) + " ");
        }


    }
}