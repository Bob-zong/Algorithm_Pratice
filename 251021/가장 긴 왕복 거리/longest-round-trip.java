import java.util.*;
import java.io.*;

class Node {
    int index, dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

}

class Element implements Comparable<Element> { // 다익스트라 코드 구현 시 필요한 클래스
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
    public static int N, M, X;

    public static ArrayList<Node>[] graph;
    public static ArrayList<Node>[] reverse_graph;
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    
    public static int ans = 0;

    public static int[] dist;
    public static int[] dist1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        reverse_graph = new ArrayList[N+1];

        dist = new int[N+1];
        dist1 = new int[N+1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
            reverse_graph[i] = new ArrayList<>();

            dist[i] = (int)1e9;
            dist1[i] = (int)1e9;

        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[vertex1].add(new Node(vertex2, weight)); // 그래프 추가하기
            reverse_graph[vertex2].add(new Node(vertex1, weight));
        }

        dist[X] = 0;
        pq.add(new Element(0, X));

        while(!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            if(dist[minIndex] != minDist)
                continue;
            
            for(int i = 0; i < graph[minIndex].size(); i++) {
                int targetIndex = graph[minIndex].get(i).index;
                int targetDist = graph[minIndex].get(i).dist;

                int newDist = dist[minIndex] + targetDist;


                if(dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        
            
        }
        
        pq = new PriorityQueue<>();
        dist1[X] = 0;
        pq.add(new Element(0, X));

        while(!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            if(dist1[minIndex] != minDist)
                continue;
            
            for(int i = 0; i < reverse_graph[minIndex].size(); i++) {
                int targetIndex = reverse_graph[minIndex].get(i).index;
                int targetDist = reverse_graph[minIndex].get(i).dist;

                int newDist = dist1[minIndex] + targetDist;


                if(dist1[targetIndex] > newDist) {
                    dist1[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        
            
        }
        
        for(int i = 1; i <= N; i++)
            ans = Math.max(ans, dist[i] + dist1[i]);

        System.out.print(ans);

    }
}