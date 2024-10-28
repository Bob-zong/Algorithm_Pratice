import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        char op;
        num1 = sc.nextInt();
        op = sc.next().charAt(0);
        num2 = sc.nextInt();
        
        if(op == '+'){
            System.out.printf("%d %s %d = %d",num1,op,num2,add(num1,num2));
        }
        else if(op == '-'){
            System.out.printf("%d %s %d = %d",num1,op,num2,sub(num1,num2));
        }
        else if(op == '*'){
            System.out.printf("%d %s %d = %d",num1,op,num2,mul(num1,num2));
        }
        else if(op == '/'){
            System.out.printf("%d %s %d = %d",num1,op,num2,div(num1,num2));
        }
        else{
            System.out.printf("False");
        }
    }

    public static int add(int a, int b){
        return a + b;
    }
    public static int sub(int a, int b){
        return a - b;
    }
    public static int mul(int a, int b){
        return a * b;
    }
    public static int div(int a, int b){
        return a/b;
    }
}