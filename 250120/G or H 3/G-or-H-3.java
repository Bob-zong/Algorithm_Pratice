import java.util.*;
import java.io.*;

public class Main {
    public static int getScore(char ch){
        if(ch == 'G')
            return 1;
        else
            return 2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int numArray[] = new int[10001];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            numArray[num] = getScore(ch);
        }
        
        int maxScore = 0;

        for(int i = 1; i <= 10000 - k ; i++){
            int sum = 0;
            for(int j = i; j <= i + k; j++){
                sum += numArray[j];
            }
            maxScore = Math.max(maxScore, sum);
        }

        bw.write(String.valueOf(maxScore));
        bw.flush();
        bw.close();
    }
}