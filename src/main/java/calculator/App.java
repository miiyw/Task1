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

        int result = 0; // 결과 저장용 변수 초기화
        // 입력된 연산 기호에 따라 연산 수행
        switch (operator) {
            case '+': // 덧셈 연산
                result = num1 + num2;
                break;
            case '-': // 뺄셈 연산
                result = num1 - num2;
                break;
            case '*': // 곱셈 연산
                result = num1 * num2;
                break;
            case '/': // 나눗셈 연산
                if (num2 == 0) { // 나눗셈에서 0으로 나누는 경우 예외 처리
                    System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                    return; // 잘못된 입력이기 때문에 프로그램 종료
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("잘못된 입력입니다."); // 정의되지 않은 연산 기호 입력 시
                return; // 프로그램 종료
        }

        System.out.println("결과: " + result);
    }
}