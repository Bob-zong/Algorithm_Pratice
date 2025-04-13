import java.util.*;
import java.io.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n;
    public static Pair[] answer;

    public static int cnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        answer = new Pair[n];
        cnt = 0;
        boolean[] removed = new boolean[n]; // 겹치는 선분 표시용

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            answer[i] = new Pair(x, y);
        }    

        Arrays.sort(answer, (a, b) -> a.x - b.x);

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(answer[i].y > answer[j].y){
                    removed[i] = true;
                    removed[j] = true;
                }
                    
                    // System.out.printf("i : %d j : %d\n", i, j);
            }
          
        }

        cnt = 0;
        for(int i = 0; i < n; i++){
            if(!removed[i]) cnt++;
        }

        System.out.print(cnt);
    }
}