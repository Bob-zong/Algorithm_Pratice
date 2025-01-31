import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k;// k는 말의 개수, n은 턴의 횟수, m은 윷놀이 판 길이
    public static int maxScore;
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static int len[];
    public static int movingLen[];

    // public static StringBuilder sb;
    
    public static void calScore(){
        int score = 0;

        for(int i = 1; i <= k; i++){
            if(movingLen[i] >= m-1){
                score += 1;
            }
        }

        maxScore = Math.max(score, maxScore);
    }
    public static void move(){
        movingLen = new int[k+1];

        for(int i = 0; i < answer.size(); i++){
            int malNum = answer.get(i);
            movingLen[malNum] += len[i]; 
        }
        calScore();
    }
    
    public static void simulate(int currNum){
        if(currNum == n){
            move();
            return;
        }
        for(int i = 1; i <= k; i++){
            answer.add(i);
            simulate(currNum + 1);
            answer.remove(answer.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        len = new int[n];
        
        maxScore = 0;

        for(int i = 0; i < n; i++){
            len[i] = Integer.parseInt(st.nextToken());
        }

        simulate(0);

        System.out.print(maxScore);
    }
}