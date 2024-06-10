package testingAssignment;

public class TestCalculator {
    public static void main(String[] args) {
        Calculator calculator=new Calculator("10 cm + 1 m - 10 mm + 1 cm");
        System.out.println(calculator.calculateExpression()+" "+calculator.scale.name());
    }

}
