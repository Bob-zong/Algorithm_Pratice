import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;

        int odd = 0;
        int even = 0;

        for (int i = 0; i<n; i++){
            int num = sc.nextInt();
            if(num % 2 != 0) odd++;
            else even++;
        }

        if (even > odd) ans = odd * 2 +1;

        else if ( even == odd ) ans = even + odd;

        else{
            ans = even * 2;
            int size = odd - even;

            if (size % 3 == 0)
                ans += (size/3)*2;
            
            else{
                if((size % 3) % 2 ==0)
                    ans += size / 3 * 2 +1;
                else
                    ans +=  size /3 * 2 - 1;;
            }
        }

        System.out.print(ans);
    }
}
