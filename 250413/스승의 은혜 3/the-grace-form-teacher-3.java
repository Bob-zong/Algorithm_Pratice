import java.util.*;
import java.io.*;

public class Main {
    // 1 ~ n 까지 반값 쿠폰 적용할 친구를 선택  o(n)
    // 1 ~ n 까지 총 비용을 계산하는 배열 생성 o(n)

    // 오름차순으로 정렬해(2n^2)
    // 
    public static int n, b;
    public static int[] giftCost;
    public static int[] deliveryCost;

    public static int getCnt(int discountIdx) {
        int[] totalCost = new int[n];
        giftCost[discountIdx] /= 2;
        for(int i = 0; i < n; i++){
            totalCost[i] = giftCost[i] + deliveryCost[i];
        }

        Arrays.sort(totalCost);

        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            sum += totalCost[i];
            if(sum > b)
                return cnt;
            
            cnt += 1;
        }

        totalCost[discountIdx] *= 2;
        return cnt;
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxCnt = 0;

        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        giftCost = new int[n];
        deliveryCost = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            giftCost[i] = Integer.parseInt(st.nextToken());
            deliveryCost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            maxCnt = Math.max(maxCnt, getCnt(i));
        }
        
        System.out.print(maxCnt);

    }
}