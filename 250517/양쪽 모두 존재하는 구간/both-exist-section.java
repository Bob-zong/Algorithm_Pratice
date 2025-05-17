// import java.util.*;
// import java.io.*;

// public class Main {
//     public static final int INT_MAX = Integer.MAX_VALUE;

//     public static int n, m;
//     public static int ans;
//     public static int[] answer;
//     public static HashMap<Integer, Integer> inMap = new HashMap<>();
//     public static HashMap<Integer, Integer> outMap = new HashMap<>();

//     public static boolean canMove(int j) {
//         if(j+1 > n)
//             return false;

//         if(outMap.getOrDefault(answer[j+1], 0) < 2)
//             return false;
        
//         return true;
//     }
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());
//         ans = INT_MAX;

//         answer = new int[n+1];

//         st = new StringTokenizer(br.readLine());

//         for(int i = 1; i <= n; i++){
//             answer[i] = Integer.parseInt(st.nextToken());
//             outMap.put(answer[i], outMap.getOrDefault(answer[i], 0) + 1);
//         }

//         int j = 0;

//         for(int i = 1; i <= n; i++) {

//             while(canMove(j)) {
//                 inMap.put(answer[j+1], inMap.getOrDefault(answer[j+1], 0) + 1);
//                 outMap.put(answer[j+1], outMap.getOrDefault(answer[j+1], 0) - 1);
//                 if(outMap.getOrDefault(answer[j+1], 0) == 0)
//                     outMap.remove(answer[j+1]);
                
//                 j++;
//             }

//             if(inMap.size() == m && outMap.size() == m){
//                 ans = Math.min(ans, j - i + 1);
//                 // System.out.println(j + " " + i);
//             }
                
//             inMap.put(answer[i], inMap.getOrDefault(answer[i], 0) - 1);
//             outMap.put(answer[i], outMap.getOrDefault(answer[i], 0) + 1);
            
//             if(inMap.getOrDefault(answer[i], 0) <= 0)
//                 inMap.remove(answer[i]);
            
//         }

//         if(ans == INT_MAX)
//             System.out.print(-1);
//         else
//             System.out.print(ans);

//     }
// }

import java.util.*;
import java.io.*;

public class Main {
    static final int INT_MAX = Integer.MAX_VALUE;

    static int n, m;
    static int[] arr;
    static int[] countIn, countOut;
    static int distinctIn = 0;
    static int distinctOut = 0;

    public static void push(int idx) {
        int num = arr[idx];

        // 구간 내로 새로 들어온 숫자라면
        if (countIn[num] == 0) distinctIn++;
        countIn[num]++;

        // 구간 외에 해당 숫자가 하나 줄어들며 0이 된다면 종류 감소
        countOut[num]--;
        if (countOut[num] == 0) distinctOut--;
    }

    public static void pop(int idx) {
        int num = arr[idx];

        // 구간 내에서 해당 숫자 제거 후 0이 되면 종류 감소
        countIn[num]--;
        if (countIn[num] == 0) distinctIn--;

        // 구간 밖에 새로 생기는 숫자라면 종류 증가
        if (countOut[num] == 0) distinctOut++;
        countOut[num]++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        countIn = new int[m + 1];
        countOut = new int[m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (countOut[arr[i]] == 0) distinctOut++;
            countOut[arr[i]]++;
        }

        int ans = INT_MAX;
        int j = 0;

        for (int i = 1; i <= n; i++) {
            // 구간 내에 m개의 수가 모두 있을 때까지 확장
            while (j + 1 <= n && distinctIn < m) {
                push(j + 1);
                j++;
            }

            // 더 확장해도 m개가 안되면 종료
            if (distinctIn < m)
                break;

            // 내부, 외부 모두 m개면 정답 후보
            if (distinctOut == m) {
                ans = Math.min(ans, j - i + 1);
            }

            // 현재 i를 윈도우에서 제외
            pop(i);
        }

        System.out.println(ans == INT_MAX ? -1 : ans);
    }
}
