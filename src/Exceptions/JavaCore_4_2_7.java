package Exceptions;

/*
Создайте статический класс Car, чтобы объекты этого типа можно было использовать в try-with-resources.
Метод close() должен выводить на экран фразу "Машина закрывается...".
Try должен ловить все непроверяемые исключения и игнорировать их.
В методе main в блоке try вызови метод drive(). Метод drive должен выводить на экран сообщение "Машина поехала."

Требования:
1. Решение должно содержать статический класс Car.
2. Решение должно содержать метод main.
3. В решение должен использоваться try с ресурсами.
*/

import java.io.IOException;

public class JavaCore_4_2_7 {


    public static class Car implements AutoCloseable {

        void drive() {
            System.out.println("Машина поехала.");
        }

        @Override
        public void close() throws Exception {
            System.out.println("Машина закрывается...");
        }
    }

    public static void main(String... args) throws RuntimeException {

        try (Car car = new Car()) {
            car.drive();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
