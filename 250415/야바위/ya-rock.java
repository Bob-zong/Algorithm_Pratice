import java.util.*;
import java.io.*;

public class Main {
    public static int n, a, b, c;

    public static int[] cup1;
    public static int[] cup2;
    public static int[] cup3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        cup1 = new int[4];
        cup2 = new int[4];
        cup3 = new int[4];

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;

        cup1[1] = 1;
        cup2[2] = 1;
        cup3[3] = 1;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            int temp1 = cup1[a];
            int temp2 = cup2[a];
            int temp3 = cup3[a];

            cup1[a] = cup1[b];
            cup2[a] = cup2[b];
            cup3[a] = cup3[b];

            cup1[b] = temp1;
            cup2[b] = temp2;
            cup3[b] = temp3;

            if(cup1[c] == 1)
                cnt1 += 1;
            if(cup2[c] == 1)
                cnt2 += 1;
            if(cup3[c] == 1)
                cnt3 += 1;
        }

        int maxCnt = 0;
        maxCnt = Math.max(cnt1, cnt2);
        maxCnt = Math.max(maxCnt, cnt3);

        System.out.print(maxCnt);


    }
}