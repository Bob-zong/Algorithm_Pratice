import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
               int sum = 0;
               for(int k = i; k <= j; k++){
                    sum += answer[k];
                    // System.out.print(answer[k]+ " ");
               }
               int len = (j - i) + 1;
               float avg = (float)sum / len;
               
               for(int k = i; k <= j; k++){
                    if(avg == answer[k]){         
                        cnt += 1;
                        // System.out.print(" avg: "+ avg + " cnt: " + cnt);
                        break;
                    }
               }
            //    System.out.println();
            }
        }
        System.out.print(cnt);
    }
}