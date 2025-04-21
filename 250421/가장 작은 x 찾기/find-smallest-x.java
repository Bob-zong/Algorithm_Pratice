import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for(int i = start[0]; i <= end[0]; i++){
            if(i % 2 != 0)
                continue;
            int num = i;
            int value = num;
            boolean condition = true;
            for(int j = 1; j < n; j++){
                value *= 2;
                if(value >= start[j] && value <= end[j])
                    continue;
                else{
                    condition = false;
                    break;
                }
            }
            if(condition){
                ans = num / 2;
                break;
            }
                
        }

        System.out.print(ans);
    }
}