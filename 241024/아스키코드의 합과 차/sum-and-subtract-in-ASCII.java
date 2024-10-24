import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        char ch1 = sc.next().charAt(0);
        char ch2 = sc.next().charAt(0);

        int num1 = (int)ch1;
        int num2 = (int)ch2;

        int sum = num1 + num2;
        int sub = num1 - num2;
        
        if(sub < 0){
            System.out.print(sum + " " + -sub);
        }else{
            System.out.print(sum + " " + sub);
        }
    }
}