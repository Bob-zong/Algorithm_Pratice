import java.util.*;
import java.io.*;

class Pair {
    int x1, x2;
    public Pair(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
public class Main {
    public static int n;
    public static int x1, x2;
    public static Pair[] answer;

    public static int maxX, minX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        answer = new Pair[n];  // ✅ 여기서 초기화 필요!
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            answer[i] = new Pair(x1, x2);
        }

        boolean condition = false;
        maxX = 0;
        minX = 0;

        

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                if(i == j)
                    continue;
                Pair dot = answer[j];
                minX = Math.min(minX,dot.x2);
                maxX = Math.max(maxX, dot.x1);    
            }
            if(minX < maxX)
                condition = true;
        }

        if(condition)
            System.out.print("Yes");
        else{
            System.out.print("No");
        }

    }
}