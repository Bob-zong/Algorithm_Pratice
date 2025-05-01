// import java.util.*;
// import java.io.*;

// public class Main {
    
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         PriorityQueue<Integer> pq = new PriorityQueue<>();

//         int n, m, k;

//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());
//         k = Integer.parseInt(st.nextToken());

//         int[] arr1 = new int[n];
//         int[] arr2 = new int[m];

//         st= new StringTokenizer(br.readLine());
//         for(int i = 0; i < n; i++)
//             arr1[i] = Integer.parseInt(st.nextToken());
//         st = new StringTokenizer(br.readLine());
//         for(int i = 0; i < m; i++)
//             arr2[i] = Integer.parseInt(st.nextToken());

//         Arrays.sort(arr1);
//         Arrays.sort(arr2);

//         int cnt = 0;
//         int idx1 = 0 , idx2 = 0;
//         pq.add(arr1[0] + arr2[0]);

//         while(cnt < k) {
//             int currSum = pq.poll();
//             cnt++;

//             if(cnt == k)
//                 break;
            
            
//         }
//     }
// }
import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair> {
    int sum, i, j;

    public Pair(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }

    public int compareTo(Pair o) {
        return this.sum - o.sum;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        Arrays.sort(B);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][M];

        pq.add(new Pair(A[0] + B[0], 0, 0));
        visited[0][0] = true;

        int count = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            count++;

            if (count == K) {
                System.out.println(curr.sum);
                break;
            }

            if (curr.i + 1 < N && !visited[curr.i + 1][curr.j]) {
                pq.add(new Pair(A[curr.i + 1] + B[curr.j], curr.i + 1, curr.j));
                visited[curr.i + 1][curr.j] = true;
            }

            if (curr.j + 1 < M && !visited[curr.i][curr.j + 1]) {
                pq.add(new Pair(A[curr.i] + B[curr.j + 1], curr.i, curr.j + 1));
                visited[curr.i][curr.j + 1] = true;
            }
        }
    }
}


// 우선 순위 q를 두개 만들어서
// 각 q에서 최소값을 뽑아
// 그다음에 그 두개를 더해서 쌍을 만들어서 넣어.

// 그리고 각 우선순위 q에서 peek 값을 체크한다음 두 개 더해서 비교해봐.
// 10^3 * 10 ^ 2 1024 -> 1000
// nlogn은 십만일 때 괜찮다. 