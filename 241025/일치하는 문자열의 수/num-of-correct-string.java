import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String A = sc.next();

        int cnt = 0;
        String compare_str;
        for(int i = 0; i < n; i++){
            compare_str = sc.next();
            if(A.equals(compare_str)){
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}