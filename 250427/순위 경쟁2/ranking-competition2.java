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
        int type = 0; // 0이 같을 때 1 - > A 가 클 때 2 B가 클 때
        for(int i = 0; i < n; i++) { 
            st = new StringTokenizer(br.readLine());
            char people = st.nextToken().charAt(0);
            int score = Integer.parseInt(st.nextToken());
            int curType = 0;

            if(people == 'A')
                aScore += score;
            else
                bScore += score;
            
            if(aScore == bScore){
                curType = 0;
            }
            else if(aScore > bScore){
                curType = 1;
            }
            else{
                curType = 2;
            }

            if(type != curType){
                cnt += 1;
                type = curType;
            }
        }

        System.out.print(cnt);
    }
}