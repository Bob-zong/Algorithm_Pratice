import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        int startTime[] = new int[n];
        int endTime[] = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            startTime[i] = Integer.parseInt(st.nextToken());
            endTime[i] = Integer.parseInt(st.nextToken());
        }

        // 한가지를 제외하고 총 운행되고 있는 시간 구하기
        // 2중포문 돌려 -> 

        int ans = Integer.MIN_VALUE;
        boolean visited[] = new boolean[1001];

        for(int i = 0; i < n; i++){
            int time = 0;
            for(int j = 0; j < n; j++){
                if(i == j)
                    continue;
                
                for(int k = 1; k <= 1000; k++){
                    if(k >= startTime[j] && k < endTime[j] && visited[k] == false){
                        time += 1;
                        visited[k] = true;
                    }
                }
            }
            ans = Math.max(time, ans);
            Arrays.fill(visited, false);
        }
        System.out.print(ans);
    }
}