import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] answer;
    public static int endOfArray;

    public static int getEndIdxOfExplosion(int startIdx, int currNum) {
        int endIdx = startIdx + 1;
        while(endIdx < endOfArray) {
            if(answer[endIdx] == currNum)
                endIdx++;
            else{
                break;
            }
        }
    
        return endIdx - 1;
    }
    public static void cutArray(int startIdx, int endIdx){
        // int[] tempArr = new int[n+1];
        int cutLen = endIdx - startIdx + 1;
        for(int i = endIdx + 1; i < endOfArray; i++){
            answer[i - cutLen] = answer[i];
        }
        endOfArray -= cutLen;
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //폭탄의 개수
        m = Integer.parseInt(st.nextToken()); //터지는 연속된 폭탄의 개수

        answer = new int[n];
        endOfArray = n;

        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(br.readLine());
        }

        boolean didExplode;
        int currIdx;
        do {
            didExplode = false;
            currIdx = 0;

            while(currIdx < endOfArray) {
                int endIdx = getEndIdxOfExplosion(currIdx, answer[currIdx]);

                if(endIdx - currIdx + 1 >=  m) {
                    // 연속한 숫자의 개수가 m개 이상이면
                    // 폭탄이 터질 수 있는 경우 해당 부분 수열을 잘라내고
                    // 폭탄이 터졌음을 기록해줍니다.
                    cutArray(currIdx, endIdx);
                    didExplode = true;
                }
                else {
                    // 주어진 시작 원소에 대하여 폭탄이 터질 수 없는 경우
                    // 다음 원소에 대하여 탐색하여 줍니다.
                    currIdx++;
                }
            }
        }
        while(didExplode);

        bw.write(String.valueOf(endOfArray));
        bw.newLine();
        
        for(int i = 0; i < endOfArray; i++){
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}

