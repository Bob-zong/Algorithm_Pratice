import java.util.Scanner;

class IntWrapper{
    int value;

    public IntWrapper(int value){
        this.value = value;
    }
}
public class Main {
    public static void modify(IntWrapper n, IntWrapper m){
        if(n.value > m.value){
            n.value += 25;
            m.value *= 2;
        }
        else{
            n.value *= 2;
            m.value += 25;
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n,m;
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        IntWrapper num1 = new IntWrapper(n);
        IntWrapper num2 = new IntWrapper(m);

        modify(num1, num2);

        System.out.print(num1.value + " " + num2.value);
    }
}