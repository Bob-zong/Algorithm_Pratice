import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int str_len = str.length();
        System.out.println(str);
        for(int i = 0; i < str_len; i++){
            str = str.substring(str_len-1, str_len) + str.substring(0,str_len-1);
            System.out.println(str);
        }
    }
}