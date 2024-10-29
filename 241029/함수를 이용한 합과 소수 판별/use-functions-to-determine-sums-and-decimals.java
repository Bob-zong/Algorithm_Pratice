import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        int cnt = checkNum(a,b);
        System.out.print(cnt);

    }
    // 일단 처음으로 소수인지 판별, 그리고 이 수의 자리수 합이 짝수인지 판별
    public static int checkNum(int num1, int num2){
        int cnt = 0;
        for(int i = num1; i <= num2; i++){
            boolean satisfied = isPrime(i);
            if(satisfied){
                int sum = checkOdd(i);
                if(sum % 2 == 0)
                    cnt++;
            }
        }
        return cnt;
    }
    
    public static int checkOdd(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            int mok = num/10;
            num = mok;
        }
        return sum;
    }


    public static boolean isPrime(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}