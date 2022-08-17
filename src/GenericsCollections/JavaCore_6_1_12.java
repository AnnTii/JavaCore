package GenericsCollections;

/*
Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов и не запрещающий элементам принимать значение null.
Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of(). Конструктор должен быть закрытым (private).
С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:

Pair<Integer, String> pair = Pair.of(1, "hello");
Integer i = pair.getFirst(); // 1
String s = pair.getSecond(); // "hello"
Pair<Integer, String> pair2 = Pair.of(1, "hello");
boolean mustBeTrue = pair.equals(pair2); // true!
boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

Пожалуйста, не меняйте модификатор доступа класса Pair. Для корректной проверки класс должен иметь пакетную видимость.
*/


public class JavaCore_6_1_12 {

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode();
    }


    public static class Pair <I,S> {

        private final I i;
        private final S s;

        public Pair(I i, S s) {
            this.i = i;
            this.s = s;
        }

        public I getFirst() {
            return i;
        }

        public S getSecond() {
            return s;
        }

        public static <I,S>Pair<I,S> of(I i, S s) {
            return new Pair<> (i,s);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (i != null ? !i.equals(pair.i) : pair.i != null) {
                return false;
            }
            return s != null ? s.equals(pair.s) : pair.s == null;
        }

        @Override
        public int hashCode() {
            int result = i != null ? i.hashCode() : 0;
            result = 31 * result + (s != null ? s.hashCode() : 0);
            return result;
        }
    }

}
