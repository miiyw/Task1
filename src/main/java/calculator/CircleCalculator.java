package calculator;

public class CircleCalculator extends Calculator {
    // 원의 넓이 생성자
    public CircleCalculator() {
        super();
    }

    // PI는 수학적으로 불변인 상수이기 때문에 final과 static 사용
    final static double PI = 3.14159;

    // 원의 넓이를 계산하는 메서드 구현
    public double calculate(double radius) {
        double result = radius * radius * PI; // 원의 넓이 계산
        resultList.add(result); // 결과 저장
        return result; // 결괏값 반환
    }
}
