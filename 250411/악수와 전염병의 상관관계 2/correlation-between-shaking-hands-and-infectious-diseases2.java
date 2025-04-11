import java.util.*;
import java.io.*;

class Pair {
    int x1, x2;
    public Pair(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }
}

public class Main {
    // answer 배열에 개발자 번호 인덱스에 값으로 몇초에 악수 했는지를 기록

    public static int n, k, p, t;
    public static int[] answer;
    public static Pair[] time;
    public static int[] remain;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // k번 동안 악수한 것만 전염 지냏ㅇ
        p = Integer.parseInt(st.nextToken()); // 처음 전염병에 걸려 있는 개발자 번호
        t = Integer.parseInt(st.nextToken()); // t개의 악수 정보가 나옴

        answer = new int[n+1];
        time = new Pair[251];
        remain = new int[n+1];
        int firstTime = 251;
        
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int handTime = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());

            time[handTime] = new Pair(d1, d2);
            
            if((d1 == p || d2 == p) && handTime < firstTime){
                firstTime = handTime;
            }
        }

        answer[p] = 1;

        // System.out.println(firstTime);
        Arrays.fill(remain, k);
        // System.out.print(time[5].x1);
        for(int i = firstTime; i <= 250; i++){
            if (time[i] == null) continue;
            
            Pair At = time[i];
            int d1 = At.x1;
            int d2 = At.x2;

            if(answer[d1] == 1 && answer[d2] == 1){
                if(remain[d1] > 0)
                    remain[d1] -= 1;
                if(remain[d2] > 0)
                    remain[d2] -= 1;
            }
            else if(answer[d1] == 1 && remain[d1] > 0){
                remain[d1] -= 1;
                answer[d2] = 1;
            }
            else if(answer[d2] == 1 && remain[d2] > 0){
                remain[d2] -= 1;
                answer[d1] = 1;
            }
        }

        for(int i = 1; i <= n; i++){
            sb.append(answer[i]);
        }
        System.out.print(sb);
    }
}