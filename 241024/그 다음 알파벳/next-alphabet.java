import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);

        char nextCh = (char)(ch+1);
        if(nextCh == (char)('z'+1)){
           System.out.print('a'); 
        }else{
            System.out.print((char)(ch+1));
        }
        
    }
}