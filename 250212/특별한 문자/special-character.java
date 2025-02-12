import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<String, Integer> map = new HashMap<>();

        char[] charArr = str.toCharArray();

        // 각 문자의 빈도수 기록
        for(int i = 0; i < charArr.length; i++){
            String key = String.valueOf(charArr[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        // 각 문자의 첫 등장 인덱스를 기록하는 맵 생성
        Map<String, Integer> firstOccurrence = new HashMap<>();
        for(int i = 0; i < charArr.length; i++){
            String key = String.valueOf(charArr[i]);
            if(!firstOccurrence.containsKey(key)){
                firstOccurrence.put(key, i);
            }
        }
        
        // map의 key를 담은 리스트 생성
        List<String> keySet = new ArrayList<>(map.keySet());
        
        // 빈도수를 우선 오름차순(또는 내림차순) 정렬, 빈도수가 같으면 입력 문자열에서 등장 인덱스가 작은 것 우선.
        keySet.sort(new Comparator<String>(){
            public int compare(String key1, String key2){
                int cmp = map.get(key1).compareTo(map.get(key2));
                if(cmp == 0){
                    // 빈도수가 같으면 firstOccurrence 값 기준 오름차순 (즉, 인덱스가 작은 값이 앞으로)
                    return firstOccurrence.get(key1).compareTo(firstOccurrence.get(key2));
                }
                return cmp;
            }
        });
        
        // 예시에서는 만약 가장 많이 나온 문자의 빈도수가 1이면 keySet의 첫 번째 값을 출력하고,
        // 그렇지 않으면 "None"을 출력함.
        // (정렬 기준에 따라 적절히 keySet.get(0)이 원하는 결과를 나타내야 합니다.)
        if(map.get(keySet.get(0)) == 1){
            System.out.print(keySet.get(0));
        }
        else{
            System.out.print("None");
        }
    }
}
