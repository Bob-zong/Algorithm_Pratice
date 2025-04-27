import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        int aScore = 0;
        int bScore = 0;
        int cScore = 0;

        int curType = 0; // 0이 같을 때 1 - > A 가 클 때 2 B가 클 때
        for(int i = 0; i < n; i++) { 
            st = new StringTokenizer(br.readLine());
            char people = st.nextToken().charAt(0);
            int score = Integer.parseInt(st.nextToken());
            int type = 0;

            if(people == 'A')
                aScore += score;
            else if(people == 'B')
                bScore += score;
            else
                cScore += score;

            int maxScore = Math.max(aScore, Math.max(bScore, cScore));

            if(aScore == bScore && bScore == cScore)
                type = 0;
            else if(aScore == bScore && aScore == maxScore)
                type = 1;
            else if(aScore == cScore && aScore == maxScore)
                type = 2;
            else if(bScore == cScore && bScore == maxScore)
                type = 3;
            else if(aScore == maxScore)
                type = 4;
            else if(bScore == maxScore)
                type = 5;
            else if(cScore == maxScore)
                type = 6;


            if(type != curType){
                cnt += 1;
                curType = type;
            }
        }
       
        System.out.print(cnt);
    }
}