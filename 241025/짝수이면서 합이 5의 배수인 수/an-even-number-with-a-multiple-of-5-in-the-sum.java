import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean satisfied = satisfiedNum(num);
        if(satisfied)
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    public static boolean satisfiedNum(int num){
        String str = Integer.toString(num);
        // int sum = Integer.parseInt((str.charAt(0) + str.charAt(1)));
        int sum = str.charAt(0) -'0' + str.charAt(1) - '0';
        if(sum % 5 == 0 && num % 2 ==0)
            return true;
        else{
            return false;
        }
    }
}