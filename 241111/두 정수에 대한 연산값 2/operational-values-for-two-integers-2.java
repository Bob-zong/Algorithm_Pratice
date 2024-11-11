import java.util.Scanner;

class IntWrapper{
    int value;

    public IntWrapper(int value){
        this.value = value;
    }
}
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();

        IntWrapper num1 = new IntWrapper(a);
        IntWrapper num2 = new IntWrapper(b);

        modify(num1,num2);
        System.out.print(num1.value +" " + num2.value);

    }

    public static void modify(IntWrapper num1, IntWrapper num2){
        if(num1.value > num2.value){
            num1.value *= 2;
            num2.value += 10;
        }else{
            num2.value *= 2;
            num1.value += 10;
        }
    }
}