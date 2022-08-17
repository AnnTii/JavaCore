package PrimitiveTypes;

/*
Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии a.
В качестве примера написано заведомо неправильное выражение. Исправьте его.

Требования:
1. Сигнатура метода должна быть: charExpression(int a)
 */



public class JavaCore_2_2_2 {
    public static void main(String[] args) {


        System.out.println(charExpression(1));

    }

//    public static char charExpression(int a) {
//        //Твой код здесь
//        char answer =  '\\';
//        int a1 = answer + a;
//        return (char) a1;
//    }

    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }
}
