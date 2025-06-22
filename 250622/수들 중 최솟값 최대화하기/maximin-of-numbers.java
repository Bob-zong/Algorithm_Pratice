import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int ans;

    public static int[][] board;
    public static boolean[] visited;

    public static ArrayList<Integer> answer = new ArrayList<>();
    
    public static void calc() {
        int sum = Integer.MAX_VALUE;

        for(int i = 0; i < answer.size(); i++) {
            sum = Math.min(sum, board[i+1][answer.get(i)]);
        }

        ans = Math.max(ans, sum);
    }
    public static void choose(int currNum) {
        if(currNum == n+1) {
            calc();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            answer.add(i);

            choose(currNum+1);

            answer.remove(answer.size()-1);
            visited[i] = false;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        board = new int[n+1][n+1];
        visited = new boolean[n+1];

        ans = 0;

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        choose(1);

        System.out.print(ans);
    }
}