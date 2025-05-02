package Lv1;

import java.util.Scanner;

public class App {
    private Scanner sc;
    private Calculator calculator;

    public App() {
        sc = new Scanner(System.in);
        calculator = new Calculator();
    }

    public void run() {
        sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter Num1: ");
                int num1 = Integer.parseInt(sc.nextLine());

                System.out.print("Enter Num2: ");
                int num2 = Integer.parseInt(sc.nextLine());

                System.out.print("Enter Type(+, -, *, /): ");
                char type = sc.nextLine().charAt(0);

                int result = calculate(num1, num2, type);
                System.out.printf("Result: %d %c %d = %d%n", num1, type, num2, result);

                System.out.print("Continue? (Terminates when exit is entered): ");
                String enter = sc.nextLine();

                if (enter.equals("exit") || enter.equals("EXIT")) {

                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println();
            }
        }

        System.out.println("Terminated..");
    }

    private int calculate(int num1, int num2, char type) {
        switch (type) {
            case '+':
                return calculator.add(num1, num2);
            case '-':
                return calculator.minus(num1, num2);
            case '*':
                return calculator.mul(num1, num2);
            case '/':
                if(num2 == 0){
                    throw new ArithmeticException("Can't Divide Zero");
                }
                return calculator.div(num1, num2);
            default:
                throw new OperatorNotFoundError("Operator Not Found");
        }
    }
}
