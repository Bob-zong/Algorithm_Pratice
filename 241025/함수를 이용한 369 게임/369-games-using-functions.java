import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        // a 이상 b 이하 수들 중 3,6,9중에 하나가 있어야 함 or 3의 배수인 수
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int cnt = 0;
        for(int i = num1; i <= num2 ; i++){
            if(threeMulti(i) || hasThree(i))
                cnt++;
        }
        System.out.print(cnt);
    }

    public static boolean threeMulti(int num){
        return (num % 3 == 0);
    }

    public static boolean hasThree(int num){
         String str = Integer.toString(num);
         boolean satisfied = false;
         for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '3' || str.charAt(i) == '6'|| str.charAt(i) == '9'){
                satisfied = true;
                break;
            }
         }
         return satisfied;
    }
}