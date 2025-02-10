import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         int n = Integer.parseInt(st.nextToken());
         int k = Integer.parseInt(st.nextToken());
         st = new StringTokenizer(br.readLine());
         long[] numArr = new long[n];
         
         // 각 숫자의 등장 횟수를 기록하는 맵
         Map<Long, Integer> freq = new HashMap<>();

         for (int i = 0; i < n; i++) {
             long num = Long.parseLong(st.nextToken());
             numArr[i] = num;
         }
         
         long count = 0;

         for(int i = 0; i < n; i++){
            long diff = k - numArr[i];

            if(freq.containsKey(diff)){
                count += freq.get(diff);
            }

            if(!freq.containsKey(numArr[i]))
                freq.put(numArr[i], 1);
            else
                freq.put(numArr[i], freq.get(numArr[i]) + 1);
         }
         
         
         System.out.println(count);
    }
}


// 맵의 각 entry를 순회하면서 두 숫자의 합이 k가 되는 경우의 수를 계산
        //  for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
        //     int num = entry.getKey();
        //     int frequency = entry.getValue();
        //     int complement = k - num;
             
        //     if (!freq.containsKey(complement))
        //         continue;

        //     //  if (num == complement) {
        //     //      // 같은 숫자인 경우, 조합 공식 적용: frequencyC2
        //     //      count += (long) frequency * (frequency - 1) / 2;
        //     //  } else if (num < complement) {
        //     //      // 중복 계산 방지를 위해 num < complement인 경우에만 계산
        //     //      count += (long) frequency * freq.get(complement);
        //     //  }
        //  }