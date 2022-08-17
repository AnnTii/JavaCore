package Exceptions;

/*
Создайте в статичном публичном методе logging логгер с именем com.javamentor.logging.Test, залогируйте им
два сообщения: первое "Все хорошо" с уровнем INFO и второе "Произошла ошибка" с уровнем WARNING.
*/

import java.util.logging.Level;
import java.util.logging.*;

public class JavaCore_4_3_6 {

    public static void main(String[] args) {


    }

    public static void logging() {
        final Logger Test = Logger.getLogger("com.javamentor.logging.Test");
        Test.log(Level.INFO, "Все хорошо");
        Test.log(Level.WARNING, "Произошла ошибка");

    }

}
