package ObjectsClassesAndPackages;

/*
Напишите статический класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов
(их коды влезают в один байт) в массиве байт. По сравнению с классом String из Java 8, хранящим каждый символ как char,
AsciiCharSequence будет занимать в два раза меньше памяти

Класс AsciiCharSequence должен:

Реализовывать интерфейс java.lang.CharSequence;
иметь конструктор, принимающий массив байт;
определять методы length(), charAt(), subSequence() и toString()

Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).

В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их
проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.
 */
import java.lang.CharSequence;
import java.util.Arrays;

public class JavaCore_3_5_6 {

    public static void main(String[] args) {

        byte[] mm = {'w','w','s','q','='};
        AsciiCharSequence asc = new AsciiCharSequence(mm);
        System.out.println(asc);
        System.out.println(asc.length());
        System.out.println(asc.charAt(3));
        System.out.println(asc.subSequence(0,5));

    }

    public static class AsciiCharSequence implements java.lang.CharSequence {

        byte[] mass;

        public AsciiCharSequence(byte[] mass) {
            this.mass = mass;
        }

        @Override
        public int length() {
            return (byte)this.mass.length;
        }

        @Override
        public char charAt(int index) {
            return (char)this.mass[index];
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return new AsciiCharSequence(Arrays.copyOfRange(mass, start, end));
        }

        @Override
        public String toString() {
            return new String(mass);
        }
    }


}
