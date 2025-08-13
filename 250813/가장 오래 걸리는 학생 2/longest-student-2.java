import java.util.*;
import java.io.*;

class Node {
    int index, dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
};

class Element implements Comparable<Element> {
    int dist, index;

    public Element(int dist, int index) {
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo(Element e) {
        return this.dist - e.dist;
    }
};



public class Main {
    public static int n, m; // vertex, edge;
    public static ArrayList<Node>[] graph;
    public static int[] dist;
    public static int ans = Integer.MIN_VALUE;
    
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        graph = new ArrayList[n+1];

        for(int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();
            
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[vertex2].add(new Node(vertex1, d));
            
        }

        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        dist[n] = 0;
        pq.add(new Element(0, n));

        while(!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            if(minDist != dist[minIndex]) {
                continue;
            }

            for(int j = 0; j < graph[minIndex].size(); j++) {
                int targetIndex = graph[minIndex].get(j).index;
                int targetDist = graph[minIndex].get(j).dist;

                int newDist = dist[minIndex] + targetDist;

                if(dist[targetIndex] > newDist){
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
                
            }
        }

        for(int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }

        System.out.print(ans);
    }   
}