import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int maxNum;

    public static ArrayList<Integer> answer = new ArrayList<>();
    public static int[] numArr;
    
    // String st = Integer.toBinaryString(int i) 십진수 2진수로 변환
    // public static void print(){
    //     int tempArr = new int[m];
    //     String strArr = new String[m];

    //     for(int i = 0; i < answer.size(); i++){
    //         tempArr[i] = answer.get(i);
    //         strArr[i] = toBinary(tempArr[i]);
    //     }

    //     String str;

    //     for(int i = 0; i < m - 1; i++){
            
    //     }
    // }
    // public static String toBinary(int num){
    //     Strintg str;

    //     while(num > 0){
    //         str += Stirng.ValueOf(num % 2);
    //         num /= 10;
    //     }

    //     return str;
    // }
    
    public static int XOR(){
        int tmp = answer.get(0);

        for(int i = 1; i < answer.size(); i++){
            tmp = tmp ^ answer.get(i);
        }
        return tmp;

    }

    public static void choose(int currNum, int idx){
        if(currNum == m){
            maxNum = Math.max(maxNum, XOR());
            return;
        }

        for(int i = idx; i < n; i++){
            answer.add(numArr[i]);
            choose(currNum + 1, idx + 1);
            answer.remove(answer.size() - 1);
        }
        
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 001, 011, 101 -> 010 101 -> 111 -> 7
        // 010, 100, 101 -> 110 101 -> 011 -> 3

        numArr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            numArr[i] = Integer.parseInt(st.nextToken());    
        }
        Arrays.sort(numArr);

        choose(0, 0);

        System.out.print(maxNum);
 
    }
}