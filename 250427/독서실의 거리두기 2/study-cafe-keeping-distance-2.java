// import java.util.*;
// import java.io.*;

// public class Main {
//     // 그냥 간격이 제일 넓은 곳 찾아서 그 중앙값에 넣으면 되는 거 아님? -- ㄴㄴ 아님
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//         int n = Integer.parseInt(br.readLine());
//         String str = br.readLine();
//         int len = str.length();
//         int answer[] = new int[len];

//         for(int i = 0; i < n; i++){
//             answer[i] = Character.getNumericValue(str.charAt(i));
//         }

//         int maxLen = 0;
//         for(int i = 0; i < len; i++){
//             int minLen = Integer.MAX_VALUE;
//             if(answer[i] == 0) {
//                 answer[i] = 1;
//             }else continue;

//             int curIdx = 0;

//             for(int j = 0; j < len; j++){
//                 if(answer[j] == 1){
//                     curIdx = j;
//                     break;
//                 }
//             }
            
//             for(int j = curIdx + 1; j < len; j++){
//                 if(answer[j] == 1 && j != curIdx) {
//                     minLen = Math.min(minLen, j-curIdx);
//                     curIdx = j;
                    
//                     // System.out.print("i : " + i + " " + minLen + " ");
//                 }
//             }
//             // System.out.println();
//             maxLen = Math.max(maxLen, minLen);
//             answer[i] = 0;
//         }
        
//         System.out.print(maxLen);
//     }
// }''

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] seat = new int[n];

        for (int i = 0; i < n; i++) {
            seat[i] = str.charAt(i) - '0';
        }

        int maxDist = 0;
        int i = 0;

        while (i < n) {
            if (seat[i] == 1) {
                i++;
                continue;
            }

            int j = i;
            while (j < n && seat[j] == 0) {
                j++;
            }

            int len = j - i;  // 빈칸 길이

            // 왼쪽 끝 or 오른쪽 끝 비어있는 경우
            if (i == 0 || j == n) {
                maxDist = Math.max(maxDist, len);
            } else {
                maxDist = Math.max(maxDist, (len + 1) / 2);
            }

            i = j;
        }

        System.out.println(maxDist);
    }
}
