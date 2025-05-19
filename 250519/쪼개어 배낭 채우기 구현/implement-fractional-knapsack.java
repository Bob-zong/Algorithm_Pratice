import java.util.*;
import java.io.*;

class Jewal implements Comparable<Jewal> {
    int weight, value;
    double unitValue;

    public Jewal(int weight, int value, double unitValue) {
        this.weight = weight;
        this.value = value;
        this.unitValue = unitValue;
    }

    @Override
    public int compareTo(Jewal j) {
        return Double.compare(j.unitValue, this.unitValue); // 내림차순
    }
}

public class Main {
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Jewal[] answer = new Jewal[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            double unitValue = (double) value / weight;
            answer[i] = new Jewal(weight, value, unitValue);
        }

        Arrays.sort(answer);

        double valueSum = 0;
        int weightSum = 0;

        for (int i = 0; i < n; i++) {
            int w = answer[i].weight;
            int v = answer[i].value;

            if (weightSum + w > m) {
                int remainWeight = m - weightSum;
                valueSum += v * ((double) remainWeight / w);
                break;
            } else {
                weightSum += w;
                valueSum += v;
            }
        }

        System.out.printf("%.3f\n", valueSum); // 결과 출력 포맷 (선택)
    }
}
