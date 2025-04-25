import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        int[] answer = new int[11];
        Arrays.fill(answer, -1);
        int cnt = 0;
    
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            
            if(answer[num] != -1){
                if(answer[num] != pos){
                    cnt += 1;
                    answer[num] = pos;
                }
            }
            else
                answer[num] = pos;
        }

        System.out.print(cnt);

    }
}