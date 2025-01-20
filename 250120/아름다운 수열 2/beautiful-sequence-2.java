import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] aArr = new int[n];
        int[] bArr = new int[m];
        int[] bCntArr = new int[101];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            bArr[i] = Integer.parseInt(st.nextToken());
            bCntArr[bArr[i]] += 1;
        }

        // 배열을 새로 하나 만들어서 값 만큼 cnt를 저장한다.
        int ans = 0;
        for(int i = 0; i <= n - m; i++){
            int tempArr[] = bCntArr.clone();
            int cnt = 0;
            for(int j = i; j < i + m; j++){
                if(tempArr[aArr[j]] != 0){
                    tempArr[aArr[j]] -= 1;
                    cnt += 1;
                }
            }
            if(cnt == m)
                ans += 1;
        }

        System.out.print(ans);

        
    }
}