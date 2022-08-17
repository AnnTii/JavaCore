package PrimitiveTypes;

/*
Реализуйте метод, проверяющий, является ли заданная строка палиндромом. Палиндромом называется строка, которая читается одинаково слева направо и справа налево (в том числе пустая).
При определении "палиндромности" строки должны учитываться только буквы и цифры. А пробелы, знаки препинания, а также регистр символов должны игнорироваться. Гарантируется, что в
метод попадают только строки, состоящие из символов ASCII (цифры, латинские буквы, знаки препинания). Т.е. русских, китайских и прочих экзотических символов в строке не будет.
Для удаления из строки всех символов, не являющихся буквами и цифрами, можно воспользоваться регулярным выражением "[^a-zA-Z0-9]".Найдите в классе String метод, выполняющий замену
по регулярному выражению и воспользуйтесь им.

Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.

Пример ввода 1: Was it a cat I saw?
Пример вывода 1: true
Пример ввода 2: A palindrome is a word, number, phrase, or other sequence of characters which reads the same backward as forward, such as madam or racecar or the number 10801.
Пример вывода 2: false
Требования:
1. Должен быть доступный статический метод boolean isPalindrome(String text)
2. Работа метода должна удовлетворять условию
 */


public class JavaCore_2_3_10 {

    public static void main(String[] args) {

        System.out.println(isPalindrome("Was it a cat I saw?"));

//        String str = "Was it a cat I saw?";
//        str = str.replaceAll("[^a-zA-Z0-9]","");          // удаление всего лишнего из строки кроме букв и цифр
//
//        StringBuffer str2 = new StringBuffer(str); // создаем объект, строку нельзя изменить, а объект можно
//        str2.reverse();                            // реверс объекта обратный
//        String obr_v_string = str2.toString();     // перевод объект обратно в строку
//
//
//
//
//        System.out.println(str);
//        System.out.println(obr_v_string);
//
//        if (str.equalsIgnoreCase(obr_v_string)) {            // сравните String и перевернутую, если true, данная строка является палиндромом
//            System.out.println("является палиндромом");
//        }
//        else {
//            System.out.println("No");
//        }

    }

    public static boolean isPalindrome(String text) {
        //Твой код здесь

        text = text.replaceAll("[^a-zA-Z0-9]","");

        StringBuffer text2 = new StringBuffer(text);
        text2.reverse();
        String toString = text2.toString();

        return text.equalsIgnoreCase(toString);
    }
}
