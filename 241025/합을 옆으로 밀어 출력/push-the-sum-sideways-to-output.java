import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;

        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            sum += num;
        }
        String str_num = Integer.toString(sum);

        str_num = str_num.substring(1) + str_num.substring(0,1);
        System.out.print(str_num);
    }
}