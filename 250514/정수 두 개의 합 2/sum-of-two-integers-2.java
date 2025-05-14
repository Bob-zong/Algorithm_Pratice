import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] answer = new int[n+1];

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(br.readLine());
            // sumVal += answer[]
        }
            

        Arrays.sort(answer);


        int ans = 0;


        int j = n;
        for(int i = 1; i <= n; i++) {
            // 구간 내 합이 k보다 크면 계속 진행합니다.
            while(j != 1 && answer[i] + answer[j] > k)
                j--;

            // j가 i보다 같거나 작아져야만 두 숫자의 합이 k 이내가 된다면
            // 더 이상 진행이 의미가 없으므로 종료합니다.
            if(j <= i)
                break;

            // 현재 숫자 arr[i]에 대해
            // [i + 1, j] 내에 있는 모든 숫자가 정확히
            // arr[i]와의 합이 k 이하가 되는 경우임을
            // 확신할 수 있으므로 j - i를 답에 더해줍니다.
            ans += j - i;
        }
        
        System.out.print(ans);
    }
}