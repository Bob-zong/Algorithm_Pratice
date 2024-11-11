import java.util.Scanner;
class intWrapper{
    int value;

    public intWrapper(int value){
        this.value = value;
    }
}
public class Main {

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        absArr(arr);
    }

    public static void absArr(int arr[]){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                System.out.print((arr[i] * -1) + " ");
            }
            else{
                System.out.print(arr[i] + " ");
            }
        }
    }


}