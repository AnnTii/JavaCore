package PrimitiveTypes;
/*
Напишите метод printOddNumbers, который принимает массив и выводит в консоль только нечетные числа из него, через запятую. Конец вывода должен перевести курсор на новую строку.

Пример ввода: [3,5,20,8,7,3,100]

Пример вывода: 3,5,7,3

Требования:
Сигнатура метода должна быть: printOddNumbers(int[] arr)
 */

//public class test10 {
//    public static void main(String[] args) {
//        int[] test = {3,5,20,8,7,3,100};
//        printOddNumbers(test);
//    }
//
//    public static void printOddNumbers(int[] arr) {
//        String pusto = "";
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] % 2 != 0) {
//                System.out.print(pusto + arr[i]);
//                pusto = ",";
//            }
//        }
//        System.out.println();
//    }
//}
public class JavaCore_2_4_16 {
    public static void main(String[] args) {
        int[] test = {3,5,20,8,7,3,100};
        printOddNumbers(test);
    }

    public static void printOddNumbers(int[] arr) {
        String str = ", ";
        String str2 = ", ";
        StringBuilder pust = new StringBuilder(str);


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                System.out.print(arr[i] + pust.toString());

            }
        }
        pust.deleteCharAt(0);
        pust.insert(1,"fff");
        System.out.println();
    }
}
