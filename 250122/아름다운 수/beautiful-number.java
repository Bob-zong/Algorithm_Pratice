import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static int cnt = 0;

    public static void choose(int currNum){
        if(currNum == n){
            if(isBeautiful()){
                cnt += 1;
            }
            return;
        }
        for(int i = 1; i <= 4; i++){
            list.add(i);
            choose(currNum + 1);
            list.remove(list.size() - 1);
        }
    }
    public static boolean isBeautiful(){
        for(int i = 0; i < n; i += list.get(i)){
            if(i + list.get(i) > n){
                return false;
            }

            for(int j = i; j < i + list.get(i); j++){
                if(list.get(j) != list.get(i))
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        choose(0);
        System.out.print(cnt);
    }
}