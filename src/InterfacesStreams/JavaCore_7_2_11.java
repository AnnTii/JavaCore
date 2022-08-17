package InterfacesStreams;

/*
Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.

Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:

minMaxConsumer.accept(min, max);
Если стрим не содержит элементов, то вызовите:

minMaxConsumer.accept(null, null);
Требования:
1. Должен быть метод public <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer)
2. Метод должен находить минимум и максимум в потоке, с помощью order.
3. Полученные данные должны быть записаны minMaxConsumer, согласно условию
*/

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaCore_7_2_11 {

    public static void main(String[] args) {

        Stream<String> elements = Stream.of("abc", "klm", "xyz");
        findMinMax(elements, Comparator.naturalOrder(), (min, max) -> System.out.println("min = " + min + " max = " + max));
        Stream<Integer> elements2 = Stream.of(9, 88, 75, 11, 1, 2, 3);
        findMinMax(elements2, Comparator.comparingInt(x -> x), (min, max) -> System.out.println("min = " + min + " max = " + max));
        findMinMax(Stream.<Integer>empty(), Comparator.comparingInt(x -> x), (min, max) -> System.out.println("min = " + min + " max = " + max));

    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<? extends T> myList = stream.sorted(order).collect(Collectors.toList());
        if (myList.isEmpty()) {
            minMaxConsumer.accept(null, null);
            return;
        }
        minMaxConsumer.accept(myList.get(0), myList.get(myList.size()-1));
    }
}
