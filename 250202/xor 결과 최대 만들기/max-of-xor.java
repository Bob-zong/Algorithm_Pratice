// import java.util.*;
// import java.io.*;

// public class Main {
//     public static int n, m;
//     public static int maxNum;

//     public static ArrayList<Integer> answer = new ArrayList<>();
//     public static int[] numArr;

//     public static int XOR(){
//         int tmp = answer.get(0);

//         for(int i = 1; i < answer.size(); i++){
//             tmp = tmp ^ answer.get(i);
//         }
//         return tmp;

//     }

//     public static void choose(int currNum, int idx){
//         if(currNum == m){
//             maxNum = Math.max(maxNum, XOR());
//             return;
//         }

//         for(int i = idx; i < n; i++){
//             answer.add(numArr[i]);
//             choose(currNum + 1, idx + 1);
//             answer.remove(answer.size() - 1);
//         }
        
        
//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());

//         // 001, 011, 101 -> 010 101 -> 111 -> 7
//         // 010, 100, 101 -> 110 101 -> 011 -> 3

//         numArr = new int[n];
        
//         st = new StringTokenizer(br.readLine());

//         for(int i = 0; i < n; i++){
//             numArr[i] = Integer.parseInt(st.nextToken());    
//         }
//         Arrays.sort(numArr);

//         choose(0, 0);

//         System.out.print(maxNum);
 
//     }
// }

import java.util.*;
import java.io.*;
 
public class Main {
    static int max = Integer.MIN_VALUE;
 
    static int N, M;
    static int[] arr;
    static List<Integer> comb = new ArrayList<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i <  N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
 
        getComb(0, 0);
        System.out.println(max);
    }
 
    private static void getComb(int lastNum, int depth) {
        if(depth == M) {
            max = Math.max(max, XOR());
            return;
        }
 
        for(int i = lastNum ; i < N ; i++) {
            comb.add(arr[i]);
            getComb(i + 1, depth + 1);
            comb.remove(comb.size() - 1);
        }
    }
 
    // XOR 비트 연산 메소드
    private static int XOR() {
        int tmp = comb.get(0);
 
        for(int i = 1 ; i < comb.size() ; i++) {
            tmp = tmp ^ comb.get(i);   // XOR 비트 연산
        }
 
        return tmp;
    }                                                                                                                                                     
}
