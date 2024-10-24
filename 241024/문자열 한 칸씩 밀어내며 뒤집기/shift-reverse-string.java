import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        //1번은 왼쪽 밀기 2번은 오른쪽 밀기 3번은 좌우로 뒤집기(역순 출력)
        String str = sc.next();
        int query_num = sc.nextInt();
        int len = str.length();
        for(int i = 0; i < query_num; i++){
            int qtype = sc.nextInt();
            if(qtype == 1){
                str = str.substring(1,len) + str.substring(0,1);
                System.out.println(str);
            }
            else if(qtype == 2){
                str = str.substring(len-1, len) + str.substring(0,len-1);
                System.out.println(str);
            }
            else{
                String temp = "";
                for(int j = len-1; j>=0; j--){
                    temp += str.charAt(j);
                }
                str = temp;
                
                System.out.println(str);
            }
        }

    }
}