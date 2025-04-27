import java.util.*;
import java.io.*;

public class Main {
    // 그냥 간격이 제일 넓은 곳 찾아서 그 중앙값에 넣으면 되는 거 아님? -- ㄴㄴ 아님
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int len = str.length();
        int answer[] = new int[len];

        for(int i = 0; i < n; i++){
            answer[i] = Character.getNumericValue(str.charAt(i));
        }

        int maxLen = 0;
        for(int i = 1; i < len-1; i++){
            int minLen = Integer.MAX_VALUE;
            if(answer[i] == 0) {
                answer[i] = 1;
            }else continue;
            int curIdx = 0;
            
            for(int j = 1; j < len; j++){
                if(answer[j] == 1) {
                    minLen = Math.min(minLen, j-curIdx);
                    curIdx = j;
                    
                    // System.out.print("i : " + i + " " + minLen + " ");
                }
            }
            // System.out.println();
            maxLen = Math.max(maxLen, minLen);
            answer[i] = 0;
        }
        
        System.out.print(maxLen);
    }
}