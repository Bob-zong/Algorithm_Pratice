import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static StringBuilder sb;
    public static ArrayList<Integer> answer = new ArrayList<>();
    // public static int[] cnt;

    public static void print(){
        for(int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i) + " ");
        }
        sb.append('\n');
    }
    public static void choose(int currNum, int lastNum){
        if(currNum == m){
            print();
            return;
        }

        for(int i = lastNum; i <= n; i++){
            answer.add(i);
            choose(currNum+1, i+1);
            answer.remove(answer.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());



        choose(0, 1);
        
        System.out.print(sb);
    }
}