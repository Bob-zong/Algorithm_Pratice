import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int year;
        year = sc.nextInt();
        checkYear(year);
    }

    public static void checkYear(int year){
        if(year % 4 == 0){
            if(year % 100 == 0 && year % 400 != 0){
                System.out.print("false");
            }
            else{
                System.out.println("true");
            }
            
        }
        else{
            System.out.println("false");
        }
    }
}