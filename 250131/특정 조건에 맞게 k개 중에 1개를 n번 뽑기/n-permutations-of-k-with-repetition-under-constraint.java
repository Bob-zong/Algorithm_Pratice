import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static StringBuilder sb;

    public static void print() {
        for(int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i) + " ");        
        }
        sb.append("\n");
        return;
    }

    public static void choose(int currNum){
        if(currNum == n+1){
            print();
            return;
        }

        for(int i = 1; i <= k; i++){
            if (answer.size() >= 2 && answer.get(answer.size() - 2) == i && answer.get(answer.size() - 1) == i)
            {
                continue;
            }
            answer.add(i);
            choose(currNum + 1);
            answer.remove(answer.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        choose(1);
        System.out.print(sb);
    }
}