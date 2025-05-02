package Lv2;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> list;

    public Calculator(){
        list = new ArrayList<>();
    }

    private int add(int num1, int num2){
        return num1 + num2;
    }

    private int minus(int num1, int num2){
        return num1 - num2;
    }

    private int mul(int num1, int num2){
        return num1 * num2;
    }

    private int div(int num1, int num2){
        return num1 / num2;
    }

    public int calculate(int num1, int num2, char type){
        int result = 0;

        switch (type) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = minus(num1, num2);
                break;
            case '*':
                result = mul(num1, num2);
                break;
            case '/':
                if(num2 == 0){
                    throw new ArithmeticException("Can't Divide Zero");
                }
                result = div(num1, num2);
                break;
            default:
                throw new OperatorNotFoundError("Operator Not Found");
        }
        list.add(result);

        return result;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(int idx, int newNumber) {
        if (idx >= 0 && idx < list.size()){
            list.set(idx, newNumber);
        }else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void removeFirst(){
        if(!list.isEmpty()){
            list.removeFirst();
        }
    }
}
