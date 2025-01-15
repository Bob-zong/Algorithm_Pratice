import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        final int BLANK = 0;

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n+1];
        int[] tempArr = new int[n+1];

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(br.readLine());
        }
        
        int endOfTempArray = 1;

        for(int i = 0; i < 2; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int row = 1; row <= n ; row++){
                if( row < start || row > end){
                    tempArr[endOfTempArray] = answer[row];
                    // System.out.print(tempArr[endOfTempArray]);
                    endOfTempArray++;
                }        
            }
            // System.out.println();
            answer = tempArr.clone();
            // for(int k = 1; k <= n; k++){
            //     System.out.print(answer[k] + " ");
            // }
            endOfTempArray = 1;
        }
        // System.out.println();
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(answer[i] != BLANK)
                cnt++;
        }
        System.out.println(cnt);
        for(int i = 1; i <= n; i++){
            if(answer[i] != BLANK)
                System.out.println(answer[i]);
        }
    }
}