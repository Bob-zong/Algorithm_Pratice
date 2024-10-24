import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String B = sc.next();
        char arr[] = B.toCharArray();
        int len = str.length();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'L'){
                str = str.substring(1,len) + str.substring(0,1);
            }
            else if(arr[i] == 'R'){
                str = str.substring(len-1, len) + str.substring(0,len-1);
            }
        }
        System.out.println(str);
    }
}