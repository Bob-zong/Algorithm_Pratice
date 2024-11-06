import java.util.Scanner;

public class Main {
    public static boolean isDate(int month, int day){
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||month == 10|| month == 12 ){
                if(day <= 31){
                    return true;
                }
                else{
                    return false;
                }
        }
        else if(month == 4 || month == 6 || month == 9 || month == 11){
            if(day <= 30){
                return true;
            }
            else{
                return false;
            }
        }
        else if(month == 2){
            if(day <= 28){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean satisfied; 
        satisfied = isDate(m,n);
        if(satisfied){
            System.out.print("Yes");
        }
        else{
            System.out.print("No");
        }
    }
}