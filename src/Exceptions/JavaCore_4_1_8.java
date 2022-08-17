package Exceptions;

/*
Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.

Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод, вызвавший
данный утилитный метод. Или null (нулевую ссылку, а не строку "null"), если метод, вызвавший
getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.

Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить
класс и метод, откуда сообщение было залогировано.

package org.stepic.java.example;

public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        // ...
    }
}

При запуске эта программа должна вывести:

null
org.your.project.Test#main
P.S. При тестировании этой программы в среде разработки вы можете получить другой результат:
вместо null в первой строчке будет напечатан какой-то посторонний класс и метод. Это связано с тем,
что среда разработки обычно запускает не ваш класс, а свой собственный, который затем уже вызывает ваш.
Чтобы этого избежать, запускайте программу командой "java" в командной строке.

P.P.S. Эта задача в уроке про исключения не случайно :)
*/

import java.util.Arrays;

public class JavaCore_4_1_8 {


    //    public static void main(String[] args) {
//        System.out.println(getCallerClassAndMethodName());
//        anotherMethod();
//
//    }
//
//    private static void anotherMethod() {
//        System.out.println(getCallerClassAndMethodName());
//
//    }
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }


    public static String getCallerClassAndMethodName() {

        StackTraceElement[] answer = new Throwable().getStackTrace();

        if (answer.length > 2) {
            return answer[2].getClassName() + "#" + answer[2].getMethodName();
        } else {
            return null;
        }
    }
}

//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        String message = "";
//        if (stackTraceElements.length >= 3) {
//            StackTraceElement element = stackTraceElements[2];
//            String className = element.getClassName();
//            String methodName = element.getMethodName();
//            message = className + "#" + methodName;
//        }
////        if(stackTraceElements.length < 4)
////            return null;




//        StackTraceElement[] methods = new Exception().getStackTrace();
//        for(StackTraceElement info: methods)
//        {
//            System.out.println(info.getClassName() +"#"+ info.getMethodName());
//        }
//
//        return null;


//    public static String getCallerClassAndMethodName() {
//
////        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
////        String answer;
////        for (int i = 0; i < stackTraceElements.length; i++) {
////
////            StackTraceElement element = stackTraceElements[i];
////            String className = element.getClassName();
////            String methodName = element.getMethodName();
////            answer = className + "# " + methodName;
////            System.out.println(answer);
////            return answer;
////        }  return null;
//
//
//        String methoda = new Throwable().getStackTrace()[1].getMethodName();
//        String classN = new Throwable().getStackTrace()[1].getClassName();
//
//        String answer2 = methoda +"#"+ classN;
//        System.out.println(answer2);
//
//        return  null;
///*
//    if(stackTraceElements.length >= 3) {
//    StackTraceElement element = stackTraceElements[2];
//    String className = element.getClassName();
//    String methodName = element.getMethodName();
//    message = className + ": " + methodName;
//    }
//*/
//
//    }



/*
1. "#".
2. new Throwable().getStackTrace(); - работает
3. new Exception().getStackTrace(); - работатет
4. Thread.currentThread().getStackTrace(); - не работает
 */