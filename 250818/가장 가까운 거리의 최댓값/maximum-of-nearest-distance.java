// import java.util.*;
// import java.io.*;

// class Node {
//     int index, dist;
    
//     public Node(int index, int dist) {
//         this.index = index;
//         this.dist = dist;
//     }

// }

// class Element implements Comparable<Element> {
//     int dist, index;

//     public Element(int dist, int index) {
//         this.dist = dist;
//         this.index = index;
//     }

//     @Override
//     public int compareTo(Element e) {
//         return this.dist - e.dist;
//     }

// }


// public class Main {
//     public static final int MIN_NUM = Integer.MIN_VALUE;

//     public static int n, m;
//     public static int A, B, C;

//     public static int ans;

//     public static ArrayList<Node>[] graph;
//     public static PriorityQueue<Element> pq = new PriorityQueue<>();

//     public static int[] dist;

//     public static void initDist() {

//         for(int i = 0; i <= n; i++) {
//             dist[i] = (int)1e9;
//         }

//         return;
//     }

//     public static void getMax() {
//         int[] vertex = new int[]{A, B, C};

//         for(int t = 0; t < 3; t++) {
//             initDist();

//             dist[vertex[t]] = 0;
//             pq.add(new Element(0, vertex[t]));

//             while(!pq.isEmpty()) {
//                 int minDist = pq.peek().dist;
//                 int minIndex = pq.peek().index;
//                 pq.poll();

//                 if(minDist != dist[minIndex])
//                     continue;
                
//                 for(int j = 0; j < graph[minIndex].size(); j++) {
//                     int targetDist = graph[minIndex].get(j).dist;
//                     int targetIndex = graph[minIndex].get(j).index;

//                     int newDist = targetDist + dist[minIndex];

//                     if(dist[targetIndex] > newDist) {
//                         dist[targetIndex] = newDist;
//                         pq.add(new Element(newDist, targetIndex));
//                     }
//                 }
//             }

//             int min = Integer.MAX_VALUE;

//             for(int i = 1; i <= n; i++) {
//                 min = Math.min(min, dist[i]);
//             }

//             ans = Math.max(ans , min);
//         }
//     }
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());

//         st = new StringTokenizer(br.readLine());
        
//         A = Integer.parseInt(st.nextToken());
//         B = Integer.parseInt(st.nextToken());
//         C = Integer.parseInt(st.nextToken());

//         graph = new ArrayList[n+1];
//         dist = new int[n+1];
        
//         ans = MIN_NUM;

//         for(int i = 0; i <= n; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         for(int i = 0; i < m; i++) {
//             st = new StringTokenizer(br.readLine());
            
//             int v1 = Integer.parseInt(st.nextToken());
//             int v2 = Integer.parseInt(st.nextToken());
//             int w = Integer.parseInt(st.nextToken());

//             graph[v1].add(new Node(v2, w));
//             graph[v2].add(new Node(v1, w));

//         }

//         getMax();

//         System.out.print(ans);

        
//     }
// }

import java.util.*;
import java.io.*;

public class Main {
    static final int INF = (int)1e9;

    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int n, m;
    static List<Edge>[] graph;

    static int[] dijkstra(int start) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if(d > dist[u]) continue;

            for(Edge e : graph[u]) {
                if(dist[e.to] > d + e.cost) {
                    dist[e.to] = d + e.cost;
                    pq.add(new int[]{e.to, dist[e.to]});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();

        int A, B, C;

        st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, cost));
            graph[v].add(new Edge(u, cost)); // 무방향 그래프라고 가정
        }

        

        int[] distA = dijkstra(A);
        int[] distB = dijkstra(B);
        int[] distC = dijkstra(C);

        int ans = -1;
        int bestNode = -1;

        for(int i=1; i<=n; i++) {
            int closest = Math.min(distA[i], Math.min(distB[i], distC[i]));
            if(closest > ans) {
                ans = closest;
                bestNode = i;
            }
        }

        System.out.println(ans);
    }
}
