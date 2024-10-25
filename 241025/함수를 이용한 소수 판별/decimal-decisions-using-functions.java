import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int sum = primeSum(num1, num2);
        System.out.print(sum);
    }

    public static int primeSum(int num1, int num2){
        int sum = 0;
        for(int i = num1; i <= num2; i++){
            if(isPrime(i)){
              sum += i;
            }
        }
        return sum;
    }
    public static boolean isPrime(int num){
        if(num == 1)
            return false;
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}