import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static StringBuilder sb;
    public static boolean[] visited;
    public static List<Integer> answer = new ArrayList<>();

    public static void print(){
        for(int i = 0; i < n; i++){
            sb.append(answer.get(i) + " ");
        }
        sb.append("\n");
    }

    public static void choose(int currNum){
        if(currNum == n+1){
            print();
            return;
        }

        for(int i = 1; i <= n; i++){
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
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];

        choose(1);

        System.out.print(sb);

    }
}   