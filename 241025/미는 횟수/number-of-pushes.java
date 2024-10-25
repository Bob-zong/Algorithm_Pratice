import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int len_a = A.length();
        int len_b = B.length();

        boolean satisfied = false;
        for(int i = 0 ; i < (len_a-1);i++){
            A = A.substring(len_a-1) + A.substring(0,len_a-1);
            if(A.equals(B)){
                System.out.print(i+1);
                satisfied = true;
            }
        }

        if(satisfied == false){
            System.out.print(-1);
        }
    }
}