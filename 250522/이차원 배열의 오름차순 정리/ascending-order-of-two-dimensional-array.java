import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Long> answer = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int order = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                long mul = i * j;
                answer.add(mul);
            }
                 
        }

        Collections.sort(answer);

        System.out.print(answer.get(order-1));
    }
}