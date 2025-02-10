import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static Map<Integer, Integer> map;
    // 두 개를 뽑는 조합 계산: nC2 = n * (n - 1) / 2
    public static long choose2(int num) {
        return num * (num - 1) / 2;
    }
    
    // 세 개를 뽑는 조합 계산: nC3 = n * (n - 1) * (n - 2) / 6
    public static long choose3(int num) {
        return num * (num - 1) * (num - 2) / 6;
    }

    // a + b + c = k 중복없이 세는 방법 a <= b <= c
    // 1. a == b == c
    // 2. a == b != c || a != b == c, 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        int count = 0;
        //num3 = k - (num1 + num2);
        for(int i = 0; i < keys.size(); i++){
            int num1 = keys.get(i);
            for(int j = i; j < keys.size(); j++){
                int num2 = keys.get(j);
                int num3 = k - (num1 + num2);

                if(num3 < num2)
                    continue;
                if(!map.containsKey(num3))
                    continue;
                    
                int cnt1 = map.get(num1);
                int cnt2 = map.get(num2);
                int cnt3 = map.get(num3);

                //모든 수가 같은 경우
                if(num1 == num2 && num2 == num3){
                    count += choose3(cnt1);
                }
                //두개가 같은 경우
                else if(num1 == num2 && num2 != num3){
                    count += choose2(cnt1) * cnt3;
                }
                else if(num1 != num2 && num2 == num3){
                    count += choose2(cnt2) * cnt1;
                }
                else if(num1 < num2 && num2 < num3){
                    count += cnt1 * cnt2 * cnt3;
                }

            }
        }

        System.out.print(count);


    }
}

