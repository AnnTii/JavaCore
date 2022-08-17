package GenericsCollections;

/*
Создайте дженерик класс Box, который может хранить в себе один объект класса, которым он параметризирован в поле с названием object.

Требования:
1. Класс должен быть параметризован T.
2. Поле должно быть приватным с именем object.
3. Класс должен иметь модификатор доступа по умолчанию.
*/

public class JavaCore_6_1_10 {

    public static void main(String[] args) {

    }

    class Box <T> {
        private T object;
    }
}
