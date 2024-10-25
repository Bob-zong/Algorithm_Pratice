import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printSquare(n);
    }

    public static void printSquare(int num){
        int cnt = 1;
        for(int row = 0; row < num; row++){
            for(int col = 0; col < num; col++){
                if(cnt == 10)
                    cnt = 1;
                System.out.print(cnt + " ");
                cnt++;
            }
            System.out.println();
        }
    }
}