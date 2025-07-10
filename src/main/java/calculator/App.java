package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) throws InvalidOperatorException, DivideByZeroException {
        Scanner sc = new Scanner(System.in);

        Calculator calc = new Calculator(); // Calculator 인스턴스 생성

        while(true){
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = sc.nextInt();

                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();

                System.out.print("사칙 연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                int result = calc.calculate(num1, num2, operator);
                System.out.println("결과: " + result + "\n");

            } catch (DivideByZeroException | InvalidOperatorException e) { // 콘솔에 예외 처리 메시지 출력할 수 있도록 처리
                System.out.println("! 예외 발생: " + e.getMessage() + "\n");
                continue; // 예외 발생 시 처음으로 다시 입력받기
            }

            // 반복 여부 확인
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String input_continue = sc.next();
            if (input_continue.trim().equals("exit")) { // 입력값이 "exit"면 반복 종료
                break;
            }
            System.out.println();
        }
    }
}