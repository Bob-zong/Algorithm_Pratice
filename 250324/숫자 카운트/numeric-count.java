import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] count1 = new int[n];
        int[] count2 = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(st.nextToken());
            count1[i] = Integer.parseInt(st.nextToken());
            count2[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                for(int k = 1; k < 10; k++){
                    if(i == j || j == k || k == i)
                        continue;
                    
                    boolean succeeded = true;

                    for(int idx = 0; idx < n; idx++){
                        int x = num[idx] / 100;
                        int y = num[idx] / 10 % 10;
                        int z = num[idx] % 10;
                        int cnt1 = 0, cnt2 = 0;
                        
                        if(x == i)
                            cnt1 += 1;
                        if(y == j)
                            cnt1 += 1;
                        if(z == k)
                            cnt1 += 1;

                        if(x == j || x == k)
                            cnt2 += 1;
                        if(y == i || y == k)
                            cnt2 += 1;
                        if(z == i || x == j)
                            cnt2 += 1;
                        
                        if(cnt1 != count1[idx] || cnt2 != count2[idx]) {
                            succeeded = false;
                            break;
                        }
                    }
                    if(succeeded) cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}