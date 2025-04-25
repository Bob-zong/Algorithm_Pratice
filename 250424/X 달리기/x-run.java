import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int t = 0;
        while (true) {
            t++;
            int total = 0;
            int speed = 1;

            for (int i = 0; i < t; i++) {
                total += speed;

                // 속도를 최대한 유지하다가 감속
                if ((t - i - 1) >= speed) speed++;
                else if ((t - i - 1) < speed) speed--;
            }

            if (total >= X) {
                System.out.println(t);
                return;
            }
        }
    }
}
