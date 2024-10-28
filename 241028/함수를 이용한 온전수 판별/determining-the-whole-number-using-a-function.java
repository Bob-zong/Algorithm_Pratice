import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        
        int cnt = checkNum(a,b);
        System.out.print(cnt);

    }
    
    public static int checkNum(int num1, int num2){
        int cnt = 0;

        for(int i = num1; i <= num2; i++){
            if(i % 2 != 0 && i % 10 != 5){
                if(i % 3 == 0 && i % 9 != 0){
                    continue;
                }
                cnt++;
            }
        }
        return cnt;
    }
}