// import java.util.*;
// import java.io.*;

// public class Main {
//     public static int n, m;
//     public static int[] answer;
//     public static int[] temp;
//     public static int endOfArray;

//     public static void cutArray(int startIdx, int endIdx){
//         int[] tempArr = new int[n+1];
//         int endOfTempArray = 1;

//         for(int i = 1; i <= endOfArray; i++){
//             if( i < startIdx || i > endIdx)
//                 tempArr[endOfTempArray++] = answer[i];
//         }
        
        
//         for(int i = 1; i <= endOfTempArray; i++)
//             answer[i] = tempArr[i];

//         endOfArray = endOfTempArray - 1;
//     }

//     public static void searchSeq(){
//         int cnt = 1;
//         for(int i = 1; i <= endOfArray; i++){
//             if(answer[i] != answer[i+1]){
//                 if(cnt >= m){
//                     cutArray((i + 1) - cnt, cnt);
//                 }
//                 cnt = 1;
//             }
//             for(int j = 1; j <= n; j++){
//                 System.out.println(answer[j]);
//             }
//             cnt += 1;  
//             System.out.println("------------");
//         }
//     }
    

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         n = Integer.parseInt(st.nextToken()); //폭탄의 개수
//         m = Integer.parseInt(st.nextToken()); //터지는 연속된 폭탄의 개수

//         answer = new int[n+1];
//         endOfArray = n;

//         for(int i = 1; i <= n; i++){
//             answer[i] = Integer.parseInt(br.readLine());
//         }

//         searchSeq();

//         // bw.write(String.valueOf(endOfArray));
//         // bw.newLine();
        
//         // for(int i = 1; i <= endOfArray; i++){
//         //     bw.write(String.valueOf(answer[i]));
//         //     bw.newLine();
//         // }
//         // bw.flush();
//         // bw.close();

//     }
// }
import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] answer;
    public static int endOfArray;

    public static void cutArray(int startIdx, int length) {
        int[] tempArr = new int[n + 1];
        int endOfTempArray = 1;

        for (int i = 1; i <= endOfArray; i++) {
            if (i < startIdx || i >= startIdx + length)
                tempArr[endOfTempArray++] = answer[i];
        }

        for (int i = 1; i < endOfTempArray; i++) { // endOfTempArray 수정
            answer[i] = tempArr[i];
        }

        endOfArray = endOfTempArray - 1;
    }

    public static void searchSeq() {
        int cnt = 1;
        for (int i = 1; i <= endOfArray; i++) {
            if (answer[i] == answer[i + 1]) {
                cnt += 1;
            } 
            else {
                if (cnt >= m) {
                    cutArray(i + 1 - cnt, cnt); // 수정: (시작 인덱스, 길이)
                    i = 0; // 배열 재탐색
                }
                cnt = 1; // 초기화
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 폭탄의 개수
        m = Integer.parseInt(st.nextToken()); // 터지는 연속된 폭탄의 개수

        answer = new int[n + 1];
        endOfArray = n;

        for (int i = 1; i <= n; i++) {
            answer[i] = Integer.parseInt(br.readLine());
        }

        searchSeq();

        bw.write(String.valueOf(endOfArray));
        bw.newLine();

        for (int i = 1; i <= endOfArray; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
