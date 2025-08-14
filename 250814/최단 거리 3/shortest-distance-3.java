import java.util.*;
import java.io.*;

class Node {
    int index, dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
    
}

class Element implements Comparable<Element> {
    int dist, index;

    public Element(int dist, int index) {
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo(Element e){
        return this.dist - e.dist;
    }

}

public class Main {
    public static int n, m;

    public static ArrayList<Node>[] graph;
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    
    public static int[] dist;

    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        graph = new ArrayList[n+1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
            dist[i] = (int)1e9;
        }
            
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[v1].add(new Node(v2, w));
            graph[v2].add(new Node(v1, w));

        }

        st = new StringTokenizer(br.readLine());
        
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist[start] = 0;
        pq.add(new Element(0, start));

        
        while(!pq.isEmpty()) {
            int minIndex = pq.peek().index;
            int minDist = pq.peek().dist;

            pq.poll();

            if(dist[minIndex] != minDist) continue;

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

        System.out.print(dist[end]);

    }
}