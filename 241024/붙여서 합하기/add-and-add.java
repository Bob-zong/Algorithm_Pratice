import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        String sum = A + B;
        String reverse_sum = B + A;

        int num1 = Integer.parseInt(sum);
        int num2 = Integer.parseInt(reverse_sum);

        System.out.print(num1 + num2);
    }
}