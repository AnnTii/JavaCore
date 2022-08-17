package GenericsCollections;

/*
Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение. Создайте класс DynamicArray,
который хранит в себе массив, и имеет методы для добавления void add(T el), void remove(int index) удаления
и извлечения T get(int index) из него элементов, при переполнении текущего массива, должен создаваться новый,
большего размера.

Для возможности работы с различными классами DynamicArray должен быть дженериком. Для решения задачи можно
воспользоваться методами из класса java.util.Arrays. Импорт этого класса уже объявлен в тестирующей системе.
Добавлять его явно не нужно

Требования:
1. должен быть класс public static class DynamicArray
2. класс DynamicArray должен иметь методы публичные void add(T el), void remove(int index) и T get(int index)
3. В случае подбора некорректного индекса ожидается, что метод get выбросит ArrayIndexOutOfBoundsException
4. класс DynamicArray должен  иметь публичный конструктор по умолчанию
5. работа методов должна соответствовать условию
*/


import java.util.Arrays;
import java.util.Collection;

public class JavaCore_6_1_13 {

    public static void main(String[] args) {

    }

    public static class DynamicArray<T> {
        private T[] array = (T[]) new Object[8];
        private int arraySize = 0;

        public void add(T el) {
            if (arraySize >= array.length) {
                array = Arrays.copyOf(array, array.length * 2);
            }
            array[arraySize++] = el;
        }

        public void remove(int index) {
            int newSize = arraySize - 1;
            System.arraycopy(array, index + 1, array, index, newSize - index);
            array[arraySize = newSize] = null;
        }

        public T get(int index) {
            if (index <= arraySize || index >= 0) {
                if (array[index] == null) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                return (T) array[index];
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }
}


