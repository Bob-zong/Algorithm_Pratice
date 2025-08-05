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
}

public class Main {
    public static int n, m, k;
    public static ArrayList<Node>[] graph;
    public static PriorityQueue<Element> pq = new PriorityQueue<>();

    public static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(br.readLine());

        dist = new int[n+1];
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
           graph[i] = new ArrayList<>();
        
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[v1].add(new Node(v2, weight));
            graph[v2].add(new Node(v1, weight));
            
        }

        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        dist[k] = 0;

        pq.add(new Element(0, k));

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
            if(dist[i] != (int)1e9)
                System.out.print(dist[i]);
            else
                System.out.print(-1);
        }
    }
}