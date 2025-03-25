import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int answer[] = new int[101];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            answer[num] += 1;
        }
        
        int ans = 0;

        for(int k = 1; k <= 100; k++){
            int cnt = 0;
            for(int i = 1; i <= 100; i++){
                for(int j = i+1; j <= 100; j++){
                    if(j - k == k - i && answer[j] == 1 && answer[i] == 1){
                        cnt += 1;
                    }
                }
            }
            ans = Math.max(cnt, ans);
        }
       
        System.out.print(ans);
        

    }
}