package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt(); //Scanner를 사용하여 양의 정수를 입력받고 변수에 저장
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 변수에 저장

        System.out.print("사칙 연산 기호를 입력하세요: "); // +, -, *, /
        char operator = sc.next().charAt(0); // 사칙 연산 기호를 적합한 타입으로 선언한 변수에 저장
        // charAt(0): 문자열의 0번째 위치에 있는 문자(첫 글자) 반환

        System.out.println("입력된 기호: " + operator);
    }
}