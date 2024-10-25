import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        maxCommonDivisor(num1, num2);
    }

    public static void maxCommonDivisor(int num1, int num2){
        int comNum = 1;
        int minNum = (num1 < num2 ? num1 : num2);
        for(int i = minNum; i>=1; i--){
            if(num1 % i == 0 && num2 % i == 0){
                System.out.print(i);
                break;
            }
                
        }
        
    }
}