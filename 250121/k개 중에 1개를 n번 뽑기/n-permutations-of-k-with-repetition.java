import java.util.*;
import java.io.*;

public class Main {
    public static int k, n;
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringBuilder sb;

    public static void choose(int currNum) {
        if(currNum == n + 1){
            print();
            return;
        }

        for(int i = 1; i <= k; i++){
            answer.add(i);
            choose(currNum + 1);
            answer.remove(answer.size() - 1);
        }
    }

    public static void print(){
        for(int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i)).append(" ");
            // bw.write(String.valueOf(answer.get(i) + " "));
            // bw.newLine();
        }
        sb.append("\n");
    }


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        choose(1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}