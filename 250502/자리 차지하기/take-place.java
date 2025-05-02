import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 사람 수
        int M = Integer.parseInt(st.nextToken());  // 좌석 수

        TreeSet<Integer> seats = new TreeSet<>();
        for (int i = 1; i <= M; i++)
            seats.add(i);  // 모든 좌석 초기화

        st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            int limit = Integer.parseInt(st.nextToken());
            Integer seat = seats.floor(limit);  // 가장 가까운 좌석 찾기

            if (seat == null)
                break;  // 더 이상 앉을 수 없음

            seats.remove(seat);  // 좌석 배정
            count++;
        }

        System.out.println(count);
    }
}
