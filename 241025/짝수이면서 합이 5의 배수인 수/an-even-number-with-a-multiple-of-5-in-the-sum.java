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
        int sum =0 ;
        for(int i = 0; i < str.length(); i++){
			sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            // Integer.parseInt는 문자열을 숫자로 바꿔
		}
        if(sum % 5 == 0 && num % 2 ==0)
            return true;
        else{
            return false;
        }
    }
}