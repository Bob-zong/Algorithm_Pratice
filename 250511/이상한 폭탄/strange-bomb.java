import java.util.*;

public class Main {
    static class Bomb implements Comparable<Bomb> {
        int number;
        int index;

        public Bomb(int number, int index) {
            this.number = number;
            this.index = index;
        }

        @Override
        public int compareTo(Bomb other) {
            return Integer.compare(other.number, this.number); // 내림차순
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Bomb> bombs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            bombs.add(new Bomb(num, i));
        }

        Collections.sort(bombs); // number 기준 내림차순 정렬

        int answer = -1;

        for (int i = 1; i < bombs.size(); i++) {
            if (bombs.get(i).number == bombs.get(i - 1).number) {
                int dist = Math.abs(bombs.get(i).index - bombs.get(i - 1).index);
                if (dist <= k) {
                    answer = bombs.get(i).number;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
