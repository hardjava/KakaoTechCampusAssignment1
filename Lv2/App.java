package Lv2;

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
                runCalculate();

                System.out.print("Do you want to remove the first value?(Y/N): ");
                char response = sc.nextLine().charAt(0);
                if (response == 'Y' || response == 'y') {
                    runRemoveFirst();
                }

                System.out.print("Do you want to change the value?(Y/N): ");
                response = sc.nextLine().charAt(0);
                if (response == 'Y' || response == 'y'){
                    changeValue();
                }

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

    private void runCalculate(){
        System.out.print("Enter Num1: ");
        int num1 = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Num2: ");
        int num2 = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Type(+, -, *, /): ");
        char type = sc.nextLine().charAt(0);
        int result = calculator.calculate(num1, num2, type);
        System.out.printf("Result: %d %c %d = %d%n", num1, type, num2, result);
        System.out.println("Saved Result: " + calculator.getList());
    }

    private void runRemoveFirst(){
        calculator.removeFirst();
        System.out.println("Saved Result: " + calculator.getList());
    }

    private void changeValue(){
        System.out.print("Enter the index (0 ~ " + (calculator.getList().size() - 1) + "): ");
        int index = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the new number: ");
        int number = Integer.parseInt(sc.nextLine());
        calculator.setList(index, number);
        System.out.println("Saved Result: " + calculator.getList());
    }
}
