import java.util.Scanner;

public class Main {
    public static int n1;
    public static int n2;

    public  static int arr1[] = new int[100];
    public  static int arr2[] = new int[100];

    public static boolean checkSubSequence(){
        for(int i = 0; i <= n1 - n2; i++){
            if(isSame(i))
                return true;
        }
        return false;
    }
    public static boolean isSame(int n) {
        for(int i = 0; i < n2; i++)
            if(arr1[i + n] != arr2[i])
                return false;
    
        return true;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        for(int i = 0; i < n1; i++){
            arr1[i] = sc.nextInt();
        }
        for(int i = 0; i < n2; i++){
            arr2[i] = sc.nextInt();
        }

        boolean satisfied = checkSubSequence();
        
        if(satisfied){
            System.out.print("Yes");
        }
        else{
            System.out.print("No");
        }
    }

       
}