import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static boolean[] visited;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void printAnswer() {
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
    public static void choose(int currNum) {
        if(currNum == n + 1) {
            printAnswer();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i])
                continue;
            
            visited[i] = true;
            arr.add(i);

            choose(currNum + 1);

            arr.remove(arr.size() - 1);
            visited[i] = false;

        }
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];

        choose(1);

    }
}