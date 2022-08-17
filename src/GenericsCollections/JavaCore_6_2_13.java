package GenericsCollections;

/*
Реализуйте метод symmetricDifference, вычисляющий симметрическую разность двух множеств.
Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

Пример ввода: [1, 2, 3} и {0, 1, 2]
Пример вывода: [0, 3]

Требования:
1. должен быть метод public static Set symmetricDifference(Set set1, Set set2)
2. метод symmetricDifference не должен изменять исходные множества
3. метод symmetricDifference должен возвращать корректный результат
*/


import java.util.HashSet;
import java.util.Set;

public class JavaCore_6_2_13 {

    public static void main(String[] args) {

        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);

        HashSet<Integer> s2 = new HashSet<>();
        s2.add(0);
        s2.add(1);
        s2.add(2);

        Set<Integer> result = symmetricDifference(s1,s2);
        System.out.println(result);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        HashSet<T> set3 = new HashSet<>(set1);
        HashSet<T> set4 = new HashSet<>(set2);
        HashSet<T> set5 = new HashSet<>();

        set3.removeAll(set2);
        set4.removeAll(set1);
        set5.addAll(set3);
        set5.addAll(set4);

        return set5;
    }
}
