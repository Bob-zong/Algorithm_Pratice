// import java.util.*;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//          StringTokenizer st = new StringTokenizer(br.readLine());
//          int n = Integer.parseInt(st.nextToken());
//          int k = Integer.parseInt(st.nextToken());
//          st = new StringTokenizer(br.readLine());
         
//          // 각 숫자의 등장 횟수를 기록하는 맵
//          Map<Integer, Integer> freq = new HashMap<>();
         
//          for (int i = 0; i < n; i++) {
//              int num = Integer.parseInt(st.nextToken());
//              freq.put(num, freq.getOrDefault(num, 0) + 1);
//          }
         
//          long count = 0;
//          // 맵의 각 entry를 순회하면서 두 숫자의 합이 k가 되는 경우의 수를 계산
//          for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
//              int num = entry.getKey();
//              int frequency = entry.getValue();
//              int complement = k - num;
             
//              if (!freq.containsKey(complement))
//                  continue;
             
//              if (num == complement) {
//                  // 같은 숫자인 경우, 조합 공식 적용: frequencyC2
//                  count += (long) frequency * (frequency - 1) / 2;
//              } else if (num < complement) {
//                  // 중복 계산 방지를 위해 num < complement인 경우에만 계산
//                  count += (long) frequency * freq.get(complement);
//              }
//          }
         
//          System.out.println(count);
//     }
// }
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n, k;
    public static long[] arr = new long[MAX_N];
    public static HashMap<Long, Integer> count = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int ans = 0;

        // 배열을 앞에서부터 순회하며 쌍을 만들어줍니다.
        for(int i = 0; i < n; i++) {
            long diff = k - arr[i];
            // 가능한 모든 쌍의 수를 세어줍니다.
            if(count.containsKey(diff))
                ans += count.get(diff);

            // 현재 숫자의 개수를 하나 증가시켜줍니다.
            if(!count.containsKey(arr[i]))
                count.put(arr[i], 1);
            else
                count.put(arr[i], count.get(arr[i]) + 1);
        }

        System.out.print(ans);
    }
}
