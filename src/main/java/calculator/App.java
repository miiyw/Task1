package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator ac = new ArithmeticCalculator(); // 사칙 연산 객체
        CircleCalculator cc = new CircleCalculator(); // 원 넓이 객체

        while(true) {
            System.out.println("1. 사칙 연산\n2. 원의 넓이 계산");
            System.out.print("메뉴를 선택하세요: ");
            int input = sc.nextInt();
            if (input == 1) {
                while (true){
                    double num1;

                    while (true) {
                        System.out.print("첫 번째 숫자를 입력하세요: ");
                        num1 = sc.nextDouble();
                        if (num1 >= 0) break; // 양수만 입력받기 위한 조건
                        System.out.println("음수는 입력할 수 없습니다.");
                    }

                    double num2;
                    while (true) {
                        System.out.print("두 번째 숫자를 입력하세요: ");
                        num2 = sc.nextDouble();
                        if (num2 >= 0) break; // 양수만 입력받기 위한 조건
                        System.out.println("음수는 입력할 수 없습니다.");
                    }

                    double result = ac.calculate(num1, num2);
                    System.out.println("결과: " + result + "\n");

                    // Getter 메서드 활용 - 연산 저장 결과 확인
                    System.out.println("연산 저장 결과: " + ac.getResultList() + "\n");

                    // Setter 활용 - 리스트 초기화 여부 확인
                    System.out.println("연산 결과가 저장된 리스트를 초기화하시겠습니까? (reset 입력 시 초기화)");
                    String input_reset = sc.next();
                    if (input_reset.trim().equals("reset")) {
                        ac.setResultList(new ArrayList<>());
                        System.out.println("리스트가 초기화되었습니다." + ac.getResultList() + "\n");
                    }

                    // 가장 먼저 저장된 데이터 삭제 메서드
                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                    String input_remove = sc.next();
                    if (input_remove.trim().equals("remove")) {
                        ac.removeResult();
                    }

                    // 저장된 연산 결과 전부 출력
                    System.out.println("저장된 연산 결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    String input_result = sc.next();
                    if (input_result.trim().equals("inquiry")) {
                        ac.inquiryResults();
                    }

                    // 반복 여부 확인
                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                    String input_continue = sc.next();
                    if (input_continue.trim().equals("exit")) { // 입력값이 "exit"면 반복 종료
                        break;
                    }
                    System.out.println();
                }
                break;
            } else if (input == 2) {
                while (true) {
                    System.out.print("원의 반지름을 입력하세요: ");
                    double radius = sc.nextInt();
                    if (radius <= 0) { // 반지름은 음수가 될 수 없음
                        System.out.println("원의 반지름은 양수만 입력 가능합니다.\n");
                        continue; // 반복문으로 돌아가 다시 입력받기
                    }
                    else { // 원의 넓이 계산
                        double result = cc.calculate(radius);
                        System.out.println("원의 넓이: " + result);

                        cc.inquiryResults();
                    }

                    // 반복 여부 확인
                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                    String input_continue = sc.next();
                    if (input_continue.trim().equals("exit")) { // 입력값이 "exit"면 반복 종료
                        break;
                    }
                    System.out.println();
                }
                break; // 내부 while문 탈출
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.\n");
            }
        }
    }
}