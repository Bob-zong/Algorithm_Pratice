import java.util.Scanner;
public class Main {
    
    public static final int MAX_LEN = 100;
    public static int arr[] = new int[MAX_LEN + 1];

    public static int arrSum(int num1, int num2){
        int sum = 0;
        for(int i = num1; i<= num2; i++){
            sum += arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int num1, num2, n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }
        
        for(int i = 0; i < m; i++){
            int sum = 0;
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            sum = arrSum(num1, num2);

            System.out.println(sum);
        }

    }
}