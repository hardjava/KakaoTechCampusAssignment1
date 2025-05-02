package Lv3;

import java.util.Scanner;

public class App {
    private Scanner sc;
    private ArithmeticCalculator arithmeticCalculator;

    public App() {
        sc = new Scanner(System.in);
        arithmeticCalculator = new ArithmeticCalculator();
    }

    public void run() {
        sc = new Scanner(System.in);

        while (true) {
            try {
                runCalculate();
                findLargerValue();

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

    private void runCalculate() {
        System.out.print("Enter Num1: ");
        String input1 = sc.nextLine();
        Number num1;
        if (input1.contains(".")) {
            num1 = Double.parseDouble(input1);
        } else {
            num1 = Integer.parseInt(input1);
        }

        System.out.print("Enter Num2: ");
        String input2 = sc.nextLine();
        Number num2;
        if (input2.contains(".")) {
            num2 = Double.parseDouble(input2);
        } else {
            num2 = Integer.parseInt(input2);
        }

        System.out.print("Enter Type(+, -, *, /): ");
        char type = sc.nextLine().charAt(0);
        arithmeticCalculator.printCalculateResult(num1, num2, OperatorType.fromChar(type));
    }

    private void findLargerValue(){
        System.out.print("Enter the num to compare: ");
        String input = sc.nextLine();
        Number num;
        if (input.contains(".")) {
            num = Double.parseDouble(input);
        } else {
            num = Integer.parseInt(input);
        }

        arithmeticCalculator.printLargerValue(num);
    }
}
