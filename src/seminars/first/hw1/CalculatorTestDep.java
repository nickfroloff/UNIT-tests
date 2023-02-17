package seminars.first.hw1;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTestDep {

    public static void main(String[] args) {

        //Лекционное задание : Добавьте функцию возведения в степень в калькулятор и протестируйте
        assertThat(Calculator.pow(10,0)).isEqualTo(1);
        assertThat(Calculator.pow(10,1)).isEqualTo(10);
        assertThat(Calculator.pow(2,8)).isEqualTo(256);

        // ДЗ 1 : Нужно написать в калькуляторе метод вычисления суммы покупки (метод принимает сумму, процент скидки и
        // возвращает сумму со скидкой) и проверить его используя AssertJ (отрицательное числа, 0, дроби, проценты >=100%, обычные скидки).
        // Все ошибки должны быть обработаны, при вводе недопустимых аргументов *можно* выбрасывать (`throw new ArithmeticException("Суть ошибки");`),
        // но нужно проверить, что все ошибки проверяются в тестах. (Заготовки метода уже есть в классе `seminars.first.hw1.Calculator` - `calculatingDiscount`)

        // Отрицательные числа. Сумма покупки
        // Ожидаемый результат: ошибка ArithmeticException с описанием "Сумма покупки не может быть отрицательной"
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(-1000, 50))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");

        // Отрицательные числа. Процент
        // Ожидаемый результат: ошибка ArithmeticException с описанием "Скидка должна быть в диапазоне от 0 до 100%"
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(1000, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

        // Процент > 100
        // Ожидаемый результат: ошибка ArithmeticException с описанием "Скидка должна быть в диапазоне от 0 до 100%"
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(1000, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

        // Тесты на корректность результата
        // Ожидаемый результат: Метод возвращает верную сумму 1000 - 25%*1000 = 750

        assertThat(Calculator.calculatingDiscount(1000, 25)).isEqualTo(750);
        assertThat(Calculator.calculatingDiscount(1000, 100)).isEqualTo(0);
        assertThat(Calculator.calculatingDiscount(1000, 0)).isEqualTo(1000);
    }
}