package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) throws InvalidOperatorException, DivideByZeroException {
        Scanner sc = new Scanner(System.in);

        // Calculator 인스턴스 생성
        List<Integer> paramList = new ArrayList<>();
        Calculator calc = new Calculator(paramList);

        while(true){
            try {
                int num1;

                while (true) {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = sc.nextInt();
                    if (num1 >= 0) break; // 양수만 입력받기 위한 조건
                    System.out.println("음수는 입력할 수 없습니다.");
                }

                int num2;
                while (true) {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = sc.nextInt();
                    if (num2 >= 0) break; // 양수만 입력받기 위한 조건
                    System.out.println("음수는 입력할 수 없습니다.");
                }

                System.out.print("사칙 연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                int result = calc.calculate(num1, num2, operator);
                System.out.println("결과: " + result + "\n");

                // Getter 메서드 활용 - 연산 저장 결과 확인
                System.out.println("연산 저장 결과: " + calc.getResultList() + "\n");

            } catch (DivideByZeroException | InvalidOperatorException e) { // 콘솔에 예외 처리 메시지 출력할 수 있도록 처리
                System.out.println("! 예외 발생: " + e.getMessage() + "\n");
                continue; // 예외 발생 시 처음으로 다시 입력받기
            }

            // Setter 활용 - 리스트 초기화 여부 확인
            System.out.println("연산 결과가 저장된 리스트를 초기화하시겠습니까? (reset 입력 시 초기화)");
            String input_reset = sc.next();
            if (input_reset.trim().equals("reset")) {
                calc.setResultList(new  ArrayList<>());
                System.out.println("리스트가 초기화되었습니다." + calc.getResultList() + "\n");
            }

            // 가장 먼저 저장된 데이터 삭제 메서드
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String input_remove = sc.next();
            if (input_remove.trim().equals("remove")) {
                calc.removeResult();
            }

            // 저장된 연산 결과 전부 출력
            System.out.println("저장된 연산 결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String input_result = sc.next();
            if (input_result.trim().equals("inquiry")) {
                calc.inquiryResults();
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