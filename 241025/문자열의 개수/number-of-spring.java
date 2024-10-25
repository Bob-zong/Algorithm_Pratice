import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        String str;
        String arr[] = new String[200];
        int idx = 0;
        while(true){
            str = sc.next();
            if(str.equals("0")){
                break;
            }
            cnt++;
            if(cnt%2 == 1){
                arr[idx++] = str;
            }

        } 
        System.out.println(cnt);
        int k =0;
        while(true){
            if(arr[k] == null)
                break;
            System.out.println(arr[k++]);
            
        }
    }
}