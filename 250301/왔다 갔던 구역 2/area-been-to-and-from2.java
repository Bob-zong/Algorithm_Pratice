import java.util.*;
import java.io.*;

public class Main {
    public static final int OFFSET = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[2001];

        int currPos = 1000;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            // num += OFFSET;
            String dir = st.nextToken();

            for(int j = 0; j < num; j++){
                if(dir.equals("R")){
                    answer[currPos] += 1;
                    // if(j < num)
                    currPos += 1;
                }
                else{
                    answer[--currPos] += 1;
                    // if(j < num)
                    // currPos -= 1;
                }
                
            }
        }
        int cnt = 0;

        for(int i = 0; i < 2001; i++){
            if(answer[i] > 1)
                cnt += 1;
        }
        System.out.print(cnt);
    }
}