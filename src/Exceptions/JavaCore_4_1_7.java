package Exceptions;

/*
Создайте новое проверяемое исключение MyNewException, и создайте метод testExp(),
который выбрасывает MyNewException при вызове.

Требования:
1. Метод testExp() должен быть публичным и иметь тип возвращаемого значения void.
2. Класс исключения должен иметь модификатор доступа по умолчанию.
3. Метод testExp() расположите вне класса исключения.
*/


import java.io.IOException;

public class JavaCore_4_1_7 {

    public static void main(String[] args) {

    }

    class MyNewException extends Exception {
        public MyNewException(String message) {
            super(message);
        }
    }

    //Реализуй метод и исключение здесь
    public void testExp() throws MyNewException {
        throw new MyNewException("Ахтунг");
    }


}
