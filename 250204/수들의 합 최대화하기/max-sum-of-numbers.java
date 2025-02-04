import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int max;

    public static int[][] numArr;
    public static boolean[] visited;
    public static List<Integer> answer = new ArrayList<>();
    public static StringBuilder sb;
    
    public static void calSumMax(){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += numArr[i][answer.get(i)];
        }
        
        max = Math.max(max, sum);
    }

    public static void choose(int currNum){
        if(currNum == n+1){
            calSumMax();
            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[i])
                continue;

            answer.add(i);
            visited[i] = true;
            choose(currNum + 1);
            answer.remove(answer.size()-1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        numArr = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        choose(1);
    
        System.out.print(max);
    }
}