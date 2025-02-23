import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    static final int MAX_NUM = 100000;
    public static int[] tileArr;
    public static int[] tileWhiteCnt;
    public static int[] tileBlackCnt;

    public static int black, white, gray; //흰색 1 검은색 2 회색 3 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int currIdx = MAX_NUM;
        
        tileArr = new int[MAX_NUM * 2 + 1];
        tileWhiteCnt = new int[MAX_NUM * 2 + 1];
        tileBlackCnt = new int[MAX_NUM * 2 + 1];

        for(int i = 1; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            while(x-- > 0){
                if(dir.equals("R")){
                    tileArr[currIdx] = 2;
                    tileBlackCnt[currIdx] += 1;
                    
                    if(tileWhiteCnt[currIdx] >= 2 && tileBlackCnt[currIdx] >= 2){
                        tileArr[currIdx] = 3;
                    }
                    
                    if(x > 0){
                        currIdx += 1;
                    }
                }
                else{
                    tileArr[currIdx] = 1;
                    tileWhiteCnt[currIdx] += 1;
                    if(tileWhiteCnt[currIdx] >= 2 && tileBlackCnt[currIdx] >= 2){
                        tileArr[currIdx] = 3;
                    }

                    if(x > 0){
                        currIdx -= 1;
                    }
                }
            }
        }

        for(int i = 0; i < 2 * MAX_NUM + 1; i++){
            if(tileArr[i] == 1)
                white += 1;
            if(tileArr[i] == 2)
                black += 1;
            if(tileArr[i] == 3)
                gray += 1;
        }

        System.out.print(white + " " + black + " " + gray);
    }
}