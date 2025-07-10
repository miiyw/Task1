package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> resultList = new ArrayList<>(); // 연산 결과가 무한으로 저장될 수 있는 리스트 생성

        while(true){
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt(); //Scanner를 사용하여 양의 정수를 입력받고 변수에 저장
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 변수에 저장

            System.out.print("사칙 연산 기호를 입력하세요: "); // +, -, *, /
            char operator = sc.next().charAt(0); // 사칙 연산 기호를 적합한 타입으로 선언한 변수에 저장
            // charAt(0): 문자열의 0번째 위치에 있는 문자(첫 글자) 반환

            int result; // 결과 저장용 변수 선언
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
                        continue; // 연산을 수행하지 않고 반복문의 처음으로 돌아감
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("잘못된 입력입니다."); // 정의되지 않은 연산 기호 입력 시
                    continue; // 연산을 수행하지 않고 반복문의 처음으로 돌아감
            }

            System.out.println("결과: " + result + "\n");

            // 결과 저장
            resultList.add(result);

            // 연산 결과 삭제 여부 확인
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String input_remove = sc.next();
            if (input_remove.trim().equals("remove")) { // 입력값이 "remove"면 가장 먼저 저장된 연산 결과 삭제
                if (!resultList.isEmpty()) {
                    resultList.remove(0);
                    System.out.println("삭제 후 현재 저장된 결과: " + resultList + "\n");
                }
                else { // 만약 리스트에 연산 결과가 없다면
                    System.out.println("리스트가 비어 있습니다."); // 안내문 출력
                }
            }

            // 저장된 연산 결과 전부 출력
            System.out.println("저장된 연산 결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String input_result = sc.next();
            if (input_result.trim().equals("inquiry")) {
                System.out.print("저장된 연산 결과: ");
                for (int number : resultList) { // 향상된 for문 사용하여 연산 결과 출력
                    System.out.print(number + " ");
                }
                System.out.println();
            }

            // 반복 여부 확인
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String input_continue = sc.next();
            if (input_continue.trim().equals("exit")) { // 입력값이 "exit"면 반복 종료
                break;
            }
            System.out.println();
        }

        // 저장된 결과 출력
        System.out.print("리스트 저장 결과: ");
        System.out.println(resultList);
    }
}