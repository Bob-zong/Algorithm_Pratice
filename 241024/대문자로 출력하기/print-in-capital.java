import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        for(int i = 0; i < str.length(); i++){
            if('a' <= str.charAt(i) && str.charAt(i) <= 'z'){
                System.out.print((char)(str.charAt(i) - 'a' + 'A'));
            }
            else if('A' <= str.charAt(i) && str.charAt(i) <= 'Z'){
                System.out.print(str.charAt(i));
            }
        }
    }
}