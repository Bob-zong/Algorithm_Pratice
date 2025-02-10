import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] numArr = new int[n];
        st = new StringTokenizer(br.readLine());
        
        // 배열과 map에 값 저장 (map은 key의 빈도수 기록)
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
            map.put(numArr[i], map.getOrDefault(numArr[i], 0) + 1);
        }
        
        // map의 key를 List로 추출
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
        // 내림차순 정렬: 먼저 map의 값(빈도수) 기준 내림차순, 그 후 key 값 기준 내림차순
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer key1, Integer key2) {
                // 빈도수 내림차순 정렬
                int cmp = map.get(key2).compareTo(map.get(key1));
                // 같은 빈도수이면 key값 내림차순 정렬
                if(cmp == 0) {
                    return key2.compareTo(key1);
                }
                return cmp;
            }
        });
        
        // keySet의 앞쪽부터 출력 (k개의 값)
        for (int i = 0; i < k && i < keySet.size(); i++) {
            System.out.print(keySet.get(i) + " ");
        }
    }
}
