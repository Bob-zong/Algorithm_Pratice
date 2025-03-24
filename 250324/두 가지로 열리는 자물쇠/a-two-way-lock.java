import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] numArr1 = new int[3];
        int[] numArr2 = new int[3];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            numArr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            numArr2[i] = Integer.parseInt(st.nextToken());
        }
        
        int cnt = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if((Math.abs(numArr1[0] - i) <= 2 || Math.abs(numArr1[0] - i) >= n-2) &&
                    (Math.abs(numArr1[1] - j) <= 2 || Math.abs(numArr1[1] - j) >= n-2) &&
                    (Math.abs(numArr1[2] - k) <= 2 || Math.abs(numArr1[2] - k) >= n-2)
                    ) cnt += 1;

                    else if((Math.abs(numArr2[0] - i) <= 2 || Math.abs(numArr2[0] - i) >= n-2) &&
                    (Math.abs(numArr2[1] - j) <= 2 || Math.abs(numArr2[1] - j) >= n-2) &&
                    (Math.abs(numArr2[2] - k) <= 2 || Math.abs(numArr2[2] - k) >= n-2)
                    ) cnt += 1;
                }
            }
        }
        
        System.out.print(cnt);

    }
}