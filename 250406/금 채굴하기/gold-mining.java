import java.util.*;
import java.io.*;

public class Main {
    // 격자에 따른 비용 -> k^2 + (k+1)^2 
    // 1. 일단 완전 탐색을 진행해서 금의 개수를 파악. n^2
    // 2. IF 금의 개수가 4개라면 총 20원 -> k는 최대 k = 2 
    // 3. k를 2부터 0까지 줄이면서 얻을 수 있는 최대 금 개수를 탐색 N^2 * k(k는 커봤자 10) *4방향 탐색
    // 4 * k * n^2 이면 됨 

    public static int n, m;  // n은 격자 크기, m은 금 한개의 가격
    public static int[][] answer;
    public static int totalGold;
    public static int maxGold;

    public static int maxK;
    
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y){
        return ( 0 <= x && x < n && 0 <= y && y < n);
    }

    public static void getTotalGold() {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(answer[i][j] == 1)
                    totalGold += 1;
            }
        }
    }

    public static void getMaxK() {
        // 계산 식 k ^ 2 + (k + 1) ^ 2 <= m * totalGold;
        int k = 0;
        int price = m * totalGold;
        int kPrice = k * k + (k + 1) * (k + 1);
        // System.out.print(price + " " + kPrice);
        if(kPrice < price)
            maxK = 0;
            
        while(true){
            k += 1;
            
            kPrice = k * k + (k + 1) * (k + 1);
            if(kPrice > price){
                k -= 1;
                maxK = k;
                break;
            }
        }
        
    }
    
    public static int checkGoldCnt(int k) { // 최소 몇개의 금을 캐야 손해가 아닌지 확인
        int kPrice = k * k + (k + 1) * (k + 1);

        int minimumM = 0;
        int price = minimumM * m;

        while(price < kPrice){
            minimumM += 1;
            price = minimumM * m;
        }

        return minimumM;
    }
    public static void simulate() {
    maxGold = 0;

    for (int x = 0; x < n; x++) {
        for (int y = 0; y < n; y++) {
            for (int k = 0; k <= 2 * n; k++) {
                int goldCnt = 0;

                for (int dx = -k; dx <= k; dx++) {
                    for (int dy = -k; dy <= k; dy++) {
                        if (Math.abs(dx) + Math.abs(dy) <= k) {
                            int nx = x + dx;
                            int ny = y + dy;

                            if (inRange(nx, ny) && answer[nx][ny] == 1) {
                                goldCnt++;
                            }
                        }
                    }
                }

                int cost = k * k + (k + 1) * (k + 1);
                int profit = goldCnt * m;

                if (profit >= cost) {
                    maxGold = Math.max(maxGold, goldCnt);
                }
            }
        }
    }
}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getTotalGold();
        getMaxK();
        simulate();

        // if(maxGold == 0 && totalGold > 0 && m >= 1){
        //     maxGold = 1;
        // }

        // System.out.print(maxK);
        // System.out.print(totalGold);
        System.out.print(maxGold);
    }
}