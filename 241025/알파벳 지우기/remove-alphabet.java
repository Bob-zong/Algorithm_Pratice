import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
        
        // 두 개의 문자열 입력 (공백으로 구분)
        String str1 = sc.next();
        String str2 = sc.next();
        
        // 첫 번째 문자열에서 숫자만 남기기
        str1 = removeNonDigits(str1);
        // 두 번째 문자열에서 숫자만 남기기
        str2 = removeNonDigits(str2);
        
        // 추출한 숫자 부분을 정수로 변환
        int number1 = Integer.parseInt(str1);
        int number2 = Integer.parseInt(str2);
        
        // 두 숫자의 합을 계산하고 출력
        int sum = number1 + number2;
        System.out.println(sum);
    }

    // 숫자가 아닌 문자를 제거하고 숫자만 남기는 함수
    private static String removeNonDigits(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // 숫자인 경우만 StringBuilder에 추가
            if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString(); // 숫자만 남긴 문자열 반환
    }
}