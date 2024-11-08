import java.util.Scanner;

public class Main {
    public static String modify(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        return s;
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String reversestr = modify(str);
        if(str.equals(reversestr)){
            System.out.print("Yes");
        }
        else{
            System.out.print("No");
        }
    }
}