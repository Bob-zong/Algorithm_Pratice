import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        //최소공배수는 두 수의 곱 / 최대공약수를 하면 나온다.
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        minCommonmulti(num1 , num2);

    }
    
    public static void minCommonmulti(int num1, int num2){
        int minNum = Math.min(num1, num2);
        int comNum = 0;
        for(int i = minNum; i >= 1; i--){
            if(num1 % i == 0 && num2 % i == 0){
                comNum = i;
                break;
            }
        }
        System.out.print((num1 * num2) / comNum);
    }
}