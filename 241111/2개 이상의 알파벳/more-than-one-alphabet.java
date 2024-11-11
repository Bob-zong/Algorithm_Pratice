import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String strA = sc.next();
        if(judgeStr(strA)){
            System.out.print("Yes");
        }
        else{
            System.out.print("No");
        }
    }
    public static boolean judgeStr(String str){
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)){
                continue;
            }
            else{
                return true;
            }
        }
        return false;
    }
}