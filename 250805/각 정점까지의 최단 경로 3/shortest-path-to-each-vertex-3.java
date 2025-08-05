import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100;

    public static int n, m;
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];

    public static int[] dist = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[v1][v2] = weight;
        }

        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        dist[1] = 0;

        // O(|V|^2) 다익스트라 코드

        for(int i = 1; i <= n; i++) {

            int minIdx = -1;

            for(int j = 1; j <= n; j++) {
                if(visited[j])
                    continue;
                
                if(minIdx == -1 || dist[minIdx] > dist[j]){
                    minIdx = j;
                }
            }

            visited[minIdx] = true;

            for(int j = 1; j <= n; j++) {

                if(graph[minIdx][j] == 0)
                    continue;
                
                dist[j] = Math.min(dist[j], dist[minIdx] + graph[minIdx][j]);
            }
        }

        for(int i = 2; i <= n; i++) {
            // 만약 도달이 불가능하다면 -1을 출력합니다.
            if(dist[i] == (int)1e9)
                System.out.println(-1);
            else
                System.out.println(dist[i]);
        }

    }
}