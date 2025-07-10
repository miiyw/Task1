package calculator;

import java.util.*;

public class Calculator {
    private List<Integer> resultList = new ArrayList<>(); // 연산 결과를 저장하는 리스트 생성

    public int calculate(int num1, int num2, char operator) throws DivideByZeroException, InvalidOperatorException {
        int result; // 결과 저장용 변수 선언

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
                    throw new DivideByZeroException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new InvalidOperatorException("잘못된 연산 기호입니다.");
        }

        resultList.add(result); // 결과 저장
        return result; // 결괏값 반환
    }
}
