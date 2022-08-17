package InputOutputAccessToSystemFiles;

/*
Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

Пример:
InputStream последовательно возвращает четыре байта: 48 49 50 51.
Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку: "0123".

Требования:
1. Метод должен быть публичным.
2. Сигнатура метода должна быть: readAsString(InputStream inputStream, Charset charset)
*/


import java.io.*;
import java.nio.charset.*;

public class JavaCore_5_3_11 {

    public static void main(String[] args) {
        byte[] array = {48, 49, 50, 51};
        Charset charset = StandardCharsets.US_ASCII;
        InputStream inputStream = new ByteArrayInputStream(array);
        try {
            System.out.println(readAsString(inputStream, charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {

        int sum;
        int result = 0;
//        StringWriter str = new StringWriter();
        StringBuilder str = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,charset);

        while ((sum = inputStreamReader.read()) > -1) {
            result = result + (byte)(sum);
            str.append((char) sum);
        }
        return String.valueOf(str);
    }

}
