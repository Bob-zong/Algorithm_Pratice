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
    public int compareTo(Element e) {
        return this.dist - e.dist;
    }
}


public class Main {
    public static int n, m;
    public static int start, end;
    public static int ans;

    public static ArrayList<Node>[] graph;
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    public static int[] path;
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        path = new int[n+1];
        graph = new ArrayList[n+1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
            dist[i] = (int)1e9;
        }
            
        
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[vertex1].add(new Node(vertex2, weight));
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist[start] = 0;
        pq.add(new Element(0, start));

        while(!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            if(dist[minIndex] != minDist)
                continue;
            
            
            for(int i = 0; i < graph[minIndex].size(); i++) {
                int targetDist = graph[minIndex].get(i).dist;
                int targetIndex = graph[minIndex].get(i).index;
                
                int newDist = dist[minIndex] + targetDist;
                
                if(dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                    path[targetIndex] = minIndex;
                }
            }

        }
        
        ans = dist[end];

        int x = end;
        ArrayList<Integer> vertices = new ArrayList<>();
        vertices.add(x);

        while(x != start){
            x = path[x];
            vertices.add(x);
        }

        System.out.println(ans);
        
        for(int i = vertices.size() - 1; i >= 0; i--)
            System.out.print(vertices.get(i) + " ");
    }
}