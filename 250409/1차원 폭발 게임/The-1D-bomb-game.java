import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] answer;
    public static int[] temp;
    public static int endOfArray;

    public static boolean searchBomb() {
        int currBomb = answer[0];
        int cnt = 0;
        boolean didExplode = false;

        for(int i = 0; i < endOfArray; i++){
            if(answer[i] == currBomb)
                cnt += 1;
            else{
                currBomb = answer[i];
                
                if(cnt >= m){
                    int startIdx = i - cnt;
                    bomb(startIdx, i);
                    didExplode = true;
                }

                cnt = 1;
            }
        }

        if (cnt >= m) {
            int startIdx = endOfArray - cnt;
            bomb(startIdx, endOfArray);
            didExplode = true;
        }

        return didExplode;

    }

    public static void bomb(int startIdx, int endIdx){
        for(int i = startIdx; i < endIdx; i++){
            answer[i] = 0;
        }
    }

    public static void moveBomb() {
        temp = new int[n];
        int endTempArray = 0;

        for(int i = 0; i < endOfArray; i++){
            if(answer[i] != 0){
                temp[endTempArray++] = answer[i];
            }
        }
        
        for(int i = 0; i < endTempArray; i++){
            answer[i] = temp[i];
        }

        endOfArray = endTempArray;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n];

        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(br.readLine());
        }
        
        endOfArray = n;

        boolean didExplode = true;
        while(didExplode) {

            didExplode = searchBomb();

            if(didExplode){
                moveBomb();
            }
        }

        sb.append(endOfArray).append("\n");

        for(int i = 0; i < endOfArray; i++){
            sb.append(answer[i]).append("\n");
        }

        System.out.print(sb);
    }
}
