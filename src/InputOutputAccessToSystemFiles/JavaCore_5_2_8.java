package InputOutputAccessToSystemFiles;

/*
Напишите метод void print(InputStream inputStream, OutputStream outputStream) который принимает
InputStream и OutputStream, считывает все байты из inputStream и записывает в OutputStream только четные.

Пример ввода: 3, 10, 4, 5, 7

Пример вывода: 10, 4

Требования:
1. Метод должен быть публичным.
2. Параметры должны иметь тип InputStream inputStream и OutputStream outputStream.
3. Сигнатура метода должна быть: print(InputStream inputStream, OutputStream outputStream)
*/

import java.io.*;

public class JavaCore_5_2_8 {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = new ByteArrayInputStream(new byte[]{3, 10, 4, 5, 7});
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        print(inputStream, outputStream);
        byte[] array = outputStream.toByteArray();
        for (byte b : array) {
            System.out.println(b);
        }
    }


    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        int buff;
        int result = 0;

        while ((buff = inputStream.read()) != -1) {
            if (buff % 2 == 0) {
                outputStream.write(buff);
            }
        }
        outputStream.flush();
    }
}
