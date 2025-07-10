package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10]; // 연산의 결과를 저장할 배열 생성
        int index = 0; // 연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수 선언

        while(true){
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
                        continue; // 연산을 수행하지 않고 반복문의 처음으로 돌아감
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("잘못된 입력입니다."); // 정의되지 않은 연산 기호 입력 시
                    continue; // 연산을 수행하지 않고 반복문의 처음으로 돌아감
            }

            System.out.println("결과: " + result);

            // 결과 저장
            if (index >= arr.length) { // 배열 초과 시
                System.out.println("결과 저장 공간이 전부 찼습니다."); // 해당 안내문 출력
            }
            else {
                arr[index] = result; // 연산의 결과를 배열에 저장
                index++; // index 증가하여 다음 index에 값이 저장될 수 있도록 함
            }

            // 반복 여부 확인
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String input = sc.next();
            if (input.trim().equals("exit")) { // 입력값이 "exit"면 반복 종료
                break;
            }
        }

        // 저장된 배열 출력
        System.out.print("배열 저장 결과: ");
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}