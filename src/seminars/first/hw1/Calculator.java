package seminars.first.hw1;

import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getOperand() {
        System.out.println("Enter operand: ");
        int operand;
        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("You have mistaken, try again");
            if (scanner.hasNext()) {
                scanner.next();
                operand = getOperand();
            } else {
                throw new IllegalStateException("Input error");
            }
        }
        return operand;
    }
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    // Примерная сигнатура и тело метода:
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки

        double discountedAmount = 0; // Сумма со скидкой (первоначальная сумма - скидка%)

        if (purchaseAmount >= 0) {

            if (discountAmount >= 0 && discountAmount <= 100) {
                discountedAmount = purchaseAmount - (purchaseAmount * discountAmount) / 100;
            } else {
                throw new ArithmeticException("Скидка должна быть в диапазоне от 0 до 100%");
            }

        } else {
            // Сумма покупки не может быть отрицательной
            throw new ArithmeticException("Сумма покупки не может быть отрицательной");
        }

        return discountedAmount; // Метод должен возвращать сумму покупки со скидкой
    }

    //Лекционное : Добавьте функцию возведения в степень в калькулятор и протестируйте
    public static int pow(int value, int powValue) {
        int result = 1;

        for (int a = 1; a <= powValue; a++) {
            if (a == 0) return 1;
            result = result * value;

        }
        return result;
    }
}