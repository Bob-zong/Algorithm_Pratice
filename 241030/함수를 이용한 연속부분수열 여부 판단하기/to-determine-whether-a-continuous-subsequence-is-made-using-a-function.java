import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
         int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        for(int i = 0; i < n1; i++){
            arr1[i] = sc.nextInt();
        }
        for(int i = 0; i < n2; i++){
            arr2[i] = sc.nextInt();
        }

        boolean satisfied = checkSubSequence(arr1, arr2);
        
        if(satisfied){
            System.out.print("Yes");
        }
        else{
            System.out.print("No");
        }
    }

    public static boolean checkSubSequence(int[] arr1, int[] arr2){

        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] == arr2[0]){
                for(int j = 1; j < arr2.length; j++){
                    if(arr1[i+j] == arr2[j])
                        continue;
                    else{
                        return false;
                    }
                }
            }
        }
        return true;


    }   
}