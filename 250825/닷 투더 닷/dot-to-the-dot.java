import java.util.*;
import java.io.*;

class Node {
    int index, L, C;

    public Node(int index, int L, int C) {
        this.L = L;
        this.C = C;
        this.index = index;
    }

}

class Element implements Comparable<Element> {
    int dist, index;
    
    public Element(int dist, int index) {
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo(Element e) {
        return this.dist - e.dist;   // dist 기준 오름차순 정렬
    }
};

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 500;
    
    // 변수 선언
    public static int n, m, x;
    public static ArrayList<Node>[] graph = new ArrayList[MAX_N + 1];
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    
    public static ArrayList<Integer> cList = new ArrayList<>();
    public static int[] dist = new int[MAX_N + 1];
    
    public static double ans = 1e9;

    public static void dijkstra(int k, int cLimit) {
        for(int i = 1; i <= n; i++)
            dist[i] = (int)1e9;

        dist[k] = 0;

        pq.add(new Element(0, k));

        while(!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            if(minDist != dist[minIndex])
                continue;
            
            for(int j = 0; j < graph[minIndex].size(); j++) {
                int targetIndex = graph[minIndex].get(j).index;
                int targetL = graph[minIndex].get(j).L;
                int targetC = graph[minIndex].get(j).C;

                if(targetC < cLimit)
                    continue;

                
                int newDist = dist[minIndex] + targetL;
                
                if(dist[targetIndex] > newDist){
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[v1].add(new Node(v2, l, c));
            graph[v2].add(new Node(v1, l, c));

            cList.add(c);

        }

        for(int i = 0; i < cList.size(); i++) {
            int cLimit = cList.get(i);
            // 1번을 시작으로 하는 Dijkstra를 진행합니다.
            dijkstra(1, cLimit);

            // N번 점까지 도달하는 최단거리를 B라 했을 때
            // A는 cLimit이 되므로
            // B + X / A 중 최솟값을 갱신합니다.
            ans = Math.min(ans, dist[n] + (double) x / cLimit);
        }

        System.out.print((int)ans);
    }
}