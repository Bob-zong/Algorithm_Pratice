import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; i++){
            String str = sc.next();
            if(str.equals("END")){
                break;
            }

            int len = str.length();
            String reverse = "";

            for(int j = len-1; j>=0; j--){
                reverse += str.charAt(j);
            }
            System.out.println(reverse);
        }    
    }
}