package calculator;

public class DivideOperator {
    public double operate(double num1 , double num2) throws DivideByZeroException {
        if (num2 == 0) { // 나눗셈에서 0으로 나누는 경우 예외 처리
            throw new DivideByZeroException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
        }
        return num1 / num2;
    }
}
