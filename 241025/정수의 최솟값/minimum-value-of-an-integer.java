import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a , b, c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        System.out.print(minValue(a,b,c));

    }

    public static int minValue(int num1, int num2, int num3){
        int min = num1;
        if(min > num2)
            min = num2;

        if(min > num3)
            min = num3;

        return min;
    }
}