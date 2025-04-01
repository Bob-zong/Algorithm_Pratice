import java.util.*;
import java.io.*;

public class Main {
    public static int n, t;
    public static int[] answer;

    public static void simulate(){
        int temp = answer[3*n];
        for(int i = 3*n; i > 0; i--){
            answer[i] = answer[i-1];
        }
        answer[1] = temp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        answer = new int[3*n+1];
        
        for(int i = 1; i <= 3*n; i++){
            if(i % 3 == 1)
                st = new StringTokenizer(br.readLine());
            answer[i] = Integer.parseInt(st.nextToken());
        }
        while(t-- > 0){
            simulate();
        }

        for(int i = 1; i <= 3*n; i++){
            sb.append(answer[i]).append(" ");
            if(i % 3 == 0)
                sb.append("\n");
        }

        System.out.print(sb);
    

    }
}