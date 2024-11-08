import java.util.Scanner;

 class IntWrapper {
        int value;
        
        //생성자 선언
        public IntWrapper(int value){
            this.value = value;
        }
    }

public class Main {
    
    public static void swap(IntWrapper num1, IntWrapper num2){
        int temp = num1.value;
        num1.value = num2.value;
        num2.value = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 여기에 코드를 작성해주세요.
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        IntWrapper num1 = new IntWrapper(n);
        IntWrapper num2 = new IntWrapper(m);

        swap(num1, num2);
        System.out.println(num1.value + " " + num2.value);
    }
}