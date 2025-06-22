import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NUM = Integer.MAX_VALUE;

    public static int n;
    public static int ans;
    public static int[][] board;
    public static boolean[] visited;
    public static ArrayList<Integer> answer = new ArrayList<>();
    
    public static void calcCost() {
        int sum = 0;
        int prev = 0 , curr = 0;

        for(int i = 1; i < answer.size(); i++) {
            prev = answer.get(i-1);
            curr = answer.get(i);

            sum += board[prev][curr];
        }
        prev = curr;
        curr = answer.get(0);

        sum += board[prev][curr];

        ans = Math.min(ans, sum);

    }
    public static void choose(int currNum) {
        if(currNum == n+1) {
            calcCost();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i]) {
                continue;
            }

             visited[i] = true;
             answer.add(i);

             choose(currNum + 1);

             answer.remove(answer.size() - 1);
             visited[i] = false;
        }


    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ans = MAX_NUM;

        board = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        choose(1);

        System.out.print(ans);
    }
}