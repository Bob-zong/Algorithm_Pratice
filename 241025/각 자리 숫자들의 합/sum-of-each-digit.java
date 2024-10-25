import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String n_str = Integer.toString(n);
        
        int sum = 0;
        for(int i = 0 ; i < n_str.length(); i++){
            char ch = n_str.charAt(i);
            // System.out.print(ch);
            sum += (ch - '0');
        }  
        System.out.print(sum);

    }
}