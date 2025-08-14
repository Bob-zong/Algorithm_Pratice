import java.util.*;

public class Main {    
    public static final int MAX_N = 1000;
    
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    public static int n, m;
    public static int a, b;
    public static List<Edge>[] graph;
    public static boolean[] visited;
    public static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();

        // 인접리스트 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[x].add(new Edge(y, z));
            graph[y].add(new Edge(x, z)); // 양방향
        }

        a = sc.nextInt();
        b = sc.nextInt();

        dist = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dist, (int)1e9);

        dist[b] = 0;

        // O(|V|^2) 다익스트라
        for (int i = 1; i <= n; i++) {
            int minIndex = -1;
            for (int j = 1; j <= n; j++) {
                if (visited[j]) continue;
                if (minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (Edge e : graph[minIndex]) {
                if (dist[e.to] > dist[minIndex] + e.weight) {
                    dist[e.to] = dist[minIndex] + e.weight;
                }
            }
        }

        // 최단 거리 출력
        System.out.println(dist[a]);

        // 경로 복원 (사전순 가장 작은 경로)
        int x = a;
        System.out.print(x + " ");
        while (x != b) {
            int nextNode = -1;
            for (Edge e : graph[x]) {
                if (dist[e.to] + e.weight == dist[x]) {
                    if (nextNode == -1 || e.to < nextNode) {
                        nextNode = e.to;
                    }
                }
            }
            x = nextNode;
            System.out.print(x + " ");
        }
    }
}
