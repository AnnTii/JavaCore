package InputOutputAccessToSystemFiles;

/*
Дан сериализуемый класс Animal:

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}
Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal. Массив байт устроен
следующим образом. Сначала идет число типа int, записанное при помощи ObjectOutputStream.writeInt(size).
Далее подряд записано указанное количество объектов типа Animal, сериализованных при помощи
ObjectOutputStream.writeObject(animal).

Если вдруг массив байт не является корректным представлением массива экземпляров Animal, то метод должен бросить
исключение java.lang.IllegalArgumentException.

Причины некорректности могут быть разные. Попробуйте подать на вход методу разные некорректные данные и посмотрите,
какие исключения будут возникать. Вот их-то и нужно превратить в IllegalArgumentException и выбросить.
Если что-то забудете, то проверяющая система подскажет. Главное не глотать никаких исключений, т.е. не оставлять
нигде пустой catch.

Требования:
1. Метод должен быть публичным.
2. Сигнатура метода должна быть: Animal[] deserializeAnimalArray(byte[] data)
*/

import java.io.*;
import java.util.Arrays;
import java.util.Objects;


public class JavaCore_5_4_7 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeInt(3);
        objectOutputStream.writeObject(new Animal("Fox"));
        objectOutputStream.writeObject(new Animal("Wolf"));
        objectOutputStream.writeObject(new Animal("Dog"));
        objectOutputStream.close();
        System.out.println(Arrays.toString(deserializeAnimalArray(byteArrayOutputStream.toByteArray())));
    }

    static class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) throws RuntimeException, ClassNotFoundException {

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int sum = objectInputStream.readInt();
            Animal[] animal = new Animal[sum];
            for (int i = 0; i < sum; i++) {

                animal[i] = (Animal) objectInputStream.readObject();
            }
            objectInputStream.close();
            return animal;
        } catch (EOFException e) {
            throw new IllegalArgumentException();
        } catch (NegativeArraySizeException e) {
            throw new IllegalArgumentException();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
