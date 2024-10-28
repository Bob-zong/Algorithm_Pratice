import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int a , b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.print(square(a,b));

    }
    public static int square(int a, int b){
        int num = 1;
        for(int i = 0; i < b; i++){
            num *= a;
        }
        return num;
    }
}