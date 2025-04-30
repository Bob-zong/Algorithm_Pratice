import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {    
    public static final int MAX_N = 200000;
    
    // 변수 선언
    public static int n;
    public static int[] arr = new int[MAX_N];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // priority queue를 이용하여 진행합니다.
        for(int i = 0; i < n; i++) {
            // 0이 아니라면,
            // 해당 숫자를 priority queue에 넣어줍니다.
            if(arr[i] != 0)
                pq.add(arr[i]);
            // 0이라면
            // 가장 작은 값을 출력하고
            // 배열에서 제거합니다.
            else {
                // 배열이 비어있다면 0을 출력합니다.
                if(pq.isEmpty())
                    System.out.println(0);
                // 그렇지 않다면 최솟값을 제거합니다.
                else {
                    int minVal = pq.poll();
                    System.out.println(minVal);
                }
            }
        }
    }
}
