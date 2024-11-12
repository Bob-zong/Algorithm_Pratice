import java.util.Scanner;

public class Main {
    public static final int MAX_len = 100;
    public static int arr[] = new int[MAX_len];

    public static int arrSum(int num1, int num2){
        int sum = 0;
        while(num2 >= 1){
            sum += arr[num2-1];
            if(num2 % 2 == 0){
                num2 /= 2;
            }
            else{
                num2 -= 1;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        for(int i = 0; i < m; i++){
            arr[i] = sc.nextInt();   
        } 
        int ans = arrSum(m,n);
        System.out.print(ans);
    }
}