import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        String[] answer = new String[n];

        StringTokenizer st;
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String result = String.valueOf(charArr);
            map.put(result, map.getOrDefault(result, 0) + 1);
        }

        
        // map의 key를 List로 추출
        List<String> keySet = new ArrayList<>(map.keySet());
        
        // 내림차순 정렬: 먼저 map의 값(빈도수) 기준 내림차순, 그 후 key 값 기준 내림차순

        keySet.sort(new Comparator<String>(){
            public int compare(String key1, String key2){
                return map.get(key2).compareTo(map.get(key1));
            }
        });

        System.out.print(map.get(keySet.get(0)) + " ");
        


        //  keySet.sort(new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer key1, Integer key2) {
        //         // 빈도수 내림차순 정렬
        //         int cmp = map.get(key2).compareTo(map.get(key1));
        //         // 같은 빈도수이면 key값 내림차순 정렬
        //         if(cmp == 0) {
        //             return key2.compareTo(key1);
        //         }
        //         return cmp;
        //     }
        // });
        
        // // keySet의 앞쪽부터 출력 (k개의 값)
        // for (int i = 0; i < k && i < keySet.size(); i++) {
        //     System.out.print(keySet.get(i) + " ");
        // }


    }
}