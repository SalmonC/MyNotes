package study.part6Lambda.Calc;

public class Demo08InvokeCalc {
    public static void main(String[] args) {
        invokeCalc(120, 130, (int a, int b) -> {return a + b;});
    }

    private static void invokeCalc(int a, int b, Calculator calculator){
        int result = calculator.calc(a, b);
        System.out.println(result);
    }
}
