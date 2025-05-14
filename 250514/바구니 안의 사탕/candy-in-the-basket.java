import java.util.*;
import java.io.*;
// public class Main {
//     public static final int MAX_POS = 1000000;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int n, k;

//         n = Integer.parseInt(st.nextToken());
//         k = Integer.parseInt(st.nextToken());

//         int[] candyPos = new int[MAX_POS+1];
//         long[] prefixSum = new long[MAX_POS+1];

//         for(int i = 0; i < n; i++){
//             st = new StringTokenizer(br.readLine());

//             int candyCnt = Integer.parseInt(st.nextToken());
//             int pos = Integer.parseInt(st.nextToken());

//             candyPos[pos] += candyCnt;
//         }

//         prefixSum[0] = candyPos[0];
//         for(int i = 1; i <= MAX_POS; i++){
//             prefixSum[i] = prefixSum[i-1] + candyPos[i];
//         }

//         long ans = 0;
//         if(k >= MAX_POS){
//             ans = prefixSum[MAX_POS];
//         }
            
//         else{
//             for(int i = k; i <= MAX_POS - k; i++) {
//                 ans = Math.max(ans, (prefixSum[i+k] - prefixSum[i-k] + candyPos[i-k]));
//             }  
//         }
        
//         // 0 1 2 3 4 5 6 7;

//         System.out.print(ans);

//     }
// }
class Candy implements Comparable<Candy> {
    int x, cnt;

    public Candy(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Candy c){
        return this.x - c.x;
    }
}

public class Main {
    public static final int MAX_N = 100000;
    public static Candy[] candies = new Candy[MAX_N + 1];
    public static int n, k;
    // 해당 내용물의 위치를 반환합니다.
    public static int getPosOfCandy(int candyIdx) {
        return candies[candyIdx].x;
    }
    // 해당 내용물에 들어 있는 사탕 수를 반환합니다.
    
    public static int getNumOfCandy(int candyIdx) {
        return candies[candyIdx].cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());        

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());

            int candyCnt = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            candies[i] = new Candy(pos, candyCnt);
        }

        Arrays.sort(candies, 1, n + 1);
        
        int ans = 0;
        
        int totalNums = 0;
        int j = 0;

        for(int i = 1; i <= n; i++) {

            while(j+1 <= n && getPosOfCandy(j+1) - getPosOfCandy(i) <= 2 * k) {
                totalNums += getNumOfCandy(j + 1);
                j++;
            }

            ans = Math.max(ans, totalNums);

            totalNums -= getNumOfCandy(i);
        }
        System.out.print(ans);

    }
}