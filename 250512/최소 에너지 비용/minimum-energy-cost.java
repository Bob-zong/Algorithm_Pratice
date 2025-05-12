import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        long[] moveCost = new long[n];

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n-1; i++) {
            moveCost[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        long[] energyCost = new long[n];

        for(int i = 0; i < n; i++)
            energyCost[i] = Integer.parseInt(st.nextToken());

        long sumCost = 0;

        long[] R = new long[n];
        long[] distArr = new long[n];
        // 뒤에서 부터 가장 싼 에너지 채우는 비용을 채워넣어놓자.
        // 5 2 1 4 4-> 에너지 충전에 최소값을 기록해놔. 5 2 4 -> 이렇게 기록이 되어 있겠지.
        // n+1 인덱스랑 비교해서 현재 값보다 더 작다? 그럼 본인 할당치만 채워
        // 근데 n+1 인덱스 값이 더 크면 자기가 남아있는 거리만큼 다채워넣어.
        R[n-1] = Integer.MAX_VALUE;
        for(int i = n-2; i >= 0; i--) {
            R[i] = Math.min(R[i+1], energyCost[i]);
            distArr[i] = distArr[i+1] + moveCost[i];
        }
        //          5 2 4 1
        // R 배열은 2 2 4 max

        for(int i = 0; i < n-1; i++) {
            if(energyCost[i] > R[i]){
                sumCost += energyCost[i] * moveCost[i];
            }
            else{
                sumCost += R[i] * distArr[i];
                break;
            }
        }
        // for(int i : distArr)
        //     System.out.println(i);
        System.out.print(sumCost);

    }
}