// import java.util.*;
// import java.io.*;

// public class Main {
//     public static final int MAX_T = 1000000;
//     public static final int MAX_N = 10000;

//     public static int n, t, k;
//     public static int[] time;

//     public static boolean isPossible(int mid) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();

//         int cnt = mid;

//         for(int i = 1; i <= mid; i++)
//             pq.add(time[i]);

//         for(int i = 0; i <= t; i++) {
//             if(pq.peek() <= i) {
//                 pq.poll();
                
//                 if(cnt < n)
//                     pq.add(time[++cnt] + i);
//             }
//         }

//         // System.out.println(pq.size());
//         return pq.isEmpty();
    

//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
        
//         n = Integer.parseInt(st.nextToken());
//         t = Integer.parseInt(st.nextToken());
//         k = 0;

//         time = new int[n+1];

//         for(int i = 1; i <= n; i++) {
//             time[i] = Integer.parseInt(br.readLine());
//         }

//         int left = 0;
//         int right = n;
//         int ans = MAX_N;

//         while(left <= right) {
//             int mid = (left + right) / 2;

//             if(isPossible(mid)) {
//                 right = mid - 1;
//                 ans = Math.min(ans, mid);
//             }
//             else {
//                 left = mid + 1;
//             }
//         }

//         System.out.print(ans);

//     }
// }


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N, T, Answer;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        T = Integer.parseInt(inArr[1]);
        time = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }
        // end input
        Answer = Integer.MAX_VALUE;
        binarySearch();
        System.out.println(Answer != Integer.MAX_VALUE ? Answer : 0);
    }

    static void binarySearch() {
        int start = 1;
        int end = N;
        while (start <= end) {
            int mid = (start + end) / 2;
            int total = mid >= N ? maxTime() : onStage(mid);
            
            if (total <= T) {   // 무대에 더 적은 애들을 올려보자
                Answer = Math.min(Answer, mid);
                end = mid - 1;
            } else {    // total > T -> 무대에 더 많은 애들을 올려야 함
                start = mid + 1;
            }
        }
    }
    static int maxTime() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, time[i]);
        }
        return max;
    }

    static int onStage(int K) {
        int t = 0;
        PriorityQueue<Integer> stage = new PriorityQueue<>();   // 무대에 올라가 있는 사람들이 내려와야 하는 시간
        int idx = 0;
        for (idx = 0; idx < K; idx++) {
            stage.add(time[idx]);
        }
        while (!stage.isEmpty()) {
            t = stage.poll();
            if (idx < N) {
                stage.add(t + time[idx++]);
            }
        }
        return t;
    }
}