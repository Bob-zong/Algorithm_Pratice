public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        for(int i = 0; i < 5; i++){
            print5Stars();
        }
    }

    //자바는 함수 이름을 camel case를 따라야 한다.
    public static void print5Stars() {
        //코드를 작성하면 됨
        for(int i = 0; i < 10; i++){
            System.out.print("*");
        }
        System.out.println();
    }
}