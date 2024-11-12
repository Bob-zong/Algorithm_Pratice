import java.util.Scanner;

public class Main {
    public static void partStr(String iStr, String oStr){
        int strIdx = iStr.indexOf(oStr);
        if(strIdx >= 0){
            System.out.print(strIdx);
        }
        else{
            System.out.print(-1);
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        String objStr = sc.next();
        partStr(inputStr, objStr);
    }
}