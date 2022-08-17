package InputOutputAccessToSystemFiles;

/*
Напишите метод int sumOfStream(InputStream inputStream), который принимает
InputStream и возвращает сумму всех его элементов.

Пример ввода: 1, 2, 4, 10

Пример вывода: 17

Требования:
1. Метод должен быть публичным.
2. Параметр должен иметь тип InputStream.
3. Сигнатура метода должна быть: sumOfStream(InputStream inputStream)
*/


import java.io.*;

public class JavaCore_5_2_7 {

    public static void main(String[] args) {
        byte[] bytes = {3,5,7,10,-2};
        InputStream inputStream = new ByteArrayInputStream(bytes);
        try {
            System.out.println(sumOfStream(inputStream));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int sumOfStream(InputStream inputStream) throws IOException {

        int summ;
        int result = 0;

        while ((summ = inputStream.read()) > -1) {
            result = result + (byte)(summ);
        }
       return result;
    }
}
