import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int speed = 1;
        int time = 0;
        int distance = 0;

        while (distance < n) {
            // 삼각수 계산 미리 저장
            int nextSpeedDistance = (speed + 1) * (speed + 2) / 2;
            int currentSpeedDistance = speed * (speed + 1) / 2;

            // 거리 증가 및 시간 증가
            distance += speed;
            time++;

            // 속도 조정
            if (distance + nextSpeedDistance <= n)
                speed++;
            else if (distance + currentSpeedDistance <= n)
                speed = speed;
            else
                speed--;
        }

        System.out.print(time);
    }
}