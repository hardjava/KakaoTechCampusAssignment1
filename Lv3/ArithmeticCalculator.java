package Lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {
    private List<Number> list;

    public ArithmeticCalculator() {
        list = new ArrayList<>();
    }

    private <T extends Number> boolean isInteger(T num) {
        if (num instanceof Double || num instanceof Float) {

            return false;
        } else {

            return true;
        }
    }

    private <T extends Number, E extends Number> void add(T num1, E num2) {
        Number result;

        System.out.print(num1 + " + " + num2 + " = ");
        if (isInteger(num1) && isInteger(num2)) {
            result = num1.intValue() + num2.intValue();
        } else {
            result = num1.doubleValue() + num2.doubleValue();
        }
        list.add(result);

        System.out.println(result);
    }

    private <T extends Number, E extends Number> void minus(T num1, E num2) {
        Number result;

        System.out.print(num1 + " - " + num2 + " = ");
        if (isInteger(num1) && isInteger(num2)) {
            result = num1.intValue() - num2.intValue();
        } else {
            result = num1.doubleValue() - num2.doubleValue();
        }
        list.add(result);

        System.out.println(result);
    }


    private <T extends Number, E extends Number> void mul(T num1, E num2) {
        Number result;

        System.out.print(num1 + " * " + num2 + " = ");
        if (isInteger(num1) && isInteger(num2)) {
            result = num1.intValue() * num2.intValue();
        } else {
            result = num1.doubleValue() * num2.doubleValue();
        }
        list.add(result);

        System.out.println(result);
    }

    private <T extends Number, E extends Number> void div(T num1, E num2) {
        if (isInteger(num2) && num2.intValue() == 0) {
            throw new ArithmeticException("Can't Divide Zero");
        } else if ((!isInteger(num2)) && num2.doubleValue() == 0.0) {
            throw new ArithmeticException("Can't Divide Zero");
        }

        Number result;

        System.out.print(num1 + " / " + num2 + " = ");
        if (isInteger(num1) && isInteger(num2)) {
            result = num1.intValue() / num2.intValue();
        } else {
            result = num1.doubleValue() / num2.doubleValue();
        }
        list.add(result);

        System.out.println(result);
    }

    public <T extends Number, E extends Number> void printCalculateResult(T num1, E num2, OperatorType type) {
        switch (type) {
            case ADD:
                add(num1, num2);
                break;
            case SUBTRACT:
                minus(num1, num2);
                break;
            case MULTIPLY:
                mul(num1, num2);
                break;
            case DIVIDE:
                div(num1, num2);
                break;
            default:
                throw new OperatorNotFoundError("Operator Not Found");
        }

        System.out.println("List: " + list);
    }

    public <T extends Number> void printLargerValue(T enterNum) {
        List<Number> largerList = list
                .stream()
                .filter(num -> num.doubleValue() > enterNum.doubleValue())
                .collect(Collectors.toList());

        System.out.println("Larger than enter number: " + largerList);
    }
}