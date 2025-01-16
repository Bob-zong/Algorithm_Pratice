import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] answer;
    public static int endOfArray;

    public static void cutArray(int startIdx, int endIdx){
        int[] tempArr = new int[n];
        int endOfTempArray = 0;

        for(int i = 0; i < endOfArray; i++){
            if( i < startIdx || i > endIdx)
                tempArr[endOfTempArray++] = answer[i];
        }
        
        for(int i = 0; i < endOfTempArray; i++)
            answer[i] = tempArr[i];

        endOfArray = endOfTempArray;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        answer = new int[n];
        endOfArray = n;

        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(br.readLine());
        }
        
        for(int k = 0; k < 2; k++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            start--; end--;
            cutArray(start, end);
        }

        System.out.println(endOfArray);
        for(int i = 0; i < endOfArray; i++)
            System.out.println(answer[i]);
        
    }
}