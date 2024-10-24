import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int len1 = str1.length();
        int len2 = str2.length();

        for(int i = 0; i<len1; i++){
            if('0' > str1.charAt(i) || str1.charAt(i) >'9'){
                str1 = str1.substring(0,i);
                // System.out.print(str1 + " ");
                break;
            }
        }

        for(int i = 0; i<len2; i++){
            if('0' > str2.charAt(i) || str2.charAt(i) >'9'){
                str2 = str2.substring(0,i);
                // System.out.print(str2);
                break;
            }
        }
        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        
        System.out.print(num1 + num2);

    }
}