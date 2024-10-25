import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int sum = num1 + num2;

        String str = Integer.toString(sum);
        int cnt = 0;
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1'){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}