import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] answer;
    public static int[] temp;
    public static int endOfArray;

    public static void cutArray(int startIdx, int endIdx){
        int[] tempArr = new int[n+1];
        int endOfTempArray = 1;

        for(int i = 1; i <= endOfArray; i++){
            if( i < startIdx || i > endIdx){
                tempArr[endOfTempArray++] = answer[i];
            //    System.out.println(tempArr[endOfTempArray-1]);
            }
                
        }
        
        for(int i = 1; i < endOfTempArray; i++){
            answer[i] = tempArr[i];
            // System.out.println(answer[i]);
        }
            

        endOfArray = endOfTempArray - 1;
        if(tempArr[1] == 0)
            Arrays.fill(answer, 0);
            // Arrays.fill(answer, endOfArray + 1, answer.length, 0);
    }

    public static void searchSeq(){
        int cnt = 1;
        for(int i = 1; i < endOfArray; i++){
            if(answer[i] == answer[i+1]){
                cnt += 1; 
                if(cnt >= m){
                    cutArray(i, i + cnt-1);
                    i = 0;
                    // System.out.println("------------");
                }    
            }
            
        }
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //폭탄의 개수
        m = Integer.parseInt(st.nextToken()); //터지는 연속된 폭탄의 개수

        answer = new int[n+1];
        endOfArray = n;

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(br.readLine());
        }

        searchSeq();

        bw.write(String.valueOf(endOfArray));
        bw.newLine();
        
        for(int i = 1; i <= endOfArray; i++){
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}

