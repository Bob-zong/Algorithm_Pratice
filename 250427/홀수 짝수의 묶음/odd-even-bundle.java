import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numbers = new int[n];

        int evenCount = 0;
        int oddCount = 0;

        // 입력 받고 짝수, 홀수 개수 세기
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        int result = 0;
        boolean expectEven = true; // 처음은 짝수 합 기대

        while (true) {
            if (expectEven) { // 짝수 합을 만들어야 할 때
                if (evenCount > 0) {
                    evenCount--;
                    result++;
                    expectEven = false;
                } else if (oddCount >= 2) {
                    oddCount -= 2;
                    result++;
                    expectEven = false;
                } else {
                    break;
                }
            } else { // 홀수 합을 만들어야 할 때
                if (oddCount > 0) {
                    oddCount--;
                    result++;
                    expectEven = true;
                } else {
                    break;
                }
            }
        }

        // 다 사용했는지 체크
        if (evenCount == 0 && oddCount == 0) {
            System.out.println(result);
        } else {
            // 모두 사용 못했으면 마지막 묶음을 하나 제거해야 함
            System.out.println(result - 1);
        }
    }
}
