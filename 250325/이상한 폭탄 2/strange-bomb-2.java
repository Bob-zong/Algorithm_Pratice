import java.util.*;
import java.io.*;

public class Main {
    public static final int MAXNUM = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());

        int boom[] = new int[n];

        for(int i = 0; i < n; i++){
            boom[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < i+1+dist && j < n; j++){
                if(boom[i] == boom[j]){
                    ans = Math.max(ans,boom[i]);
                }
            }
        }

        System.out.print(ans);
    }
}