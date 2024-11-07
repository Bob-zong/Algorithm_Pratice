import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int year, month, day;
        year = sc.nextInt();
        month = sc.nextInt();
        day = sc.nextInt();
        boolean satisfied;
        satisfied = isDay(year,month,day);

        if(satisfied){
            System.out.print(printWeather(month));
        }
        else{
            System.out.print(-1);
        }
    }
    public static boolean isDay(int year, int month,int day){
        if(month == 4 || month == 6 || month == 9 || month == 11){
            if(day <= 30)
                return true;
            else
                return false;
        }
        else if(month == 2){
            if(isYear(year))
                if(day <= 29)
                    return true;
                else{
                    return false;
                }
            else{
                if(day <= 28)
                    return true;
                else    
                    return false;
            } 
        }else{
            return true;
        }
        
    }

    public static boolean isYear(int year){
        if(year % 4 != 0){
             return false;
        }
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    return true;
                }
                return false;
            }
            return true;
        }
        return false; 
    }
    public static String printWeather(int month){
        String strWeather;
        if(month >= 3 && month <= 5){
            strWeather = "Spring";
            return strWeather;
        }
        else if(month >= 6 && month <= 8){
            strWeather = "Summer";
            return strWeather;
        }
        else if(month >= 9 && month <= 11){
            strWeather = "Fall";
            return strWeather;
        }
        else{
            strWeather = "Winter";
            return strWeather;
        }
            
    }
}