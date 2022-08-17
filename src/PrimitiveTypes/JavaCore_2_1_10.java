package PrimitiveTypes;
/*
Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c ?
Допустимая погрешность – 0.0001 (1E-4)
Можно использовать класс Math и его методы. Класс Math доступен всегда, импортировать его не надо.
В качестве примера написано заведомо неправильное выражение. Исправьте его.

Требования:
Метод должен иметь сигнатуру: doubleExpression(double a, double b, double c)
 */

public class JavaCore_2_1_10 {

    public static void main(String[] args) {

        System.out.println(doubleExpression(1,2,3));
    }

    public static boolean doubleExpression(double a, double b, double c) {

//        double result = Math.abs(-13.5); // 13.5
//        boolean aa = Math.abs(a + b) == c;
//        boolean aa = (a + b) == c;
//        System.out.println(aa);

        return Math.abs((a + b) - c) < 0.0001;

//        Например (0.1 + 0.2) == 0.3 сравниваем до точности 0.00001:
//        Math.abs((a + b) - c) < 0.00001 возврат boolean
    }

}

