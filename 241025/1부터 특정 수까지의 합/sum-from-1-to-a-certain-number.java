import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ans = sumDivisor(num);
        System.out.print(ans/10);
    }

    public static int sumDivisor(int num){
        int sum = 0;
        for(int i = 1; i <= num; i++){
            sum += i;
        }
        return sum;
    }
}