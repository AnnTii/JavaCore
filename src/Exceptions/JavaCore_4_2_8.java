package Exceptions;

/*
Вспомним нашего старого знакомого робота. Теперь мы будем давать роботу команды удаленно,
подключаясь к нему по беспроводному каналу связи.

Подключение к роботу представляется в программе интерфейсом RobotConnection:

public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();
}
Да, робот с тех пор поумнел и стал понимать команду на перемещение в заданную точку (метод moveRobotTo).
Ему больше не нужны пошаговые инструкции.

RobotConnection - это временно устанавливаемое соединение, которое надо закрывать, когда оно больше не нужно.
Для закрытия соединения в интерфейсе есть метод close().

За установку соединения отвечает RobotConnectionManager:

public interface RobotConnectionManager {
    RobotConnection getConnection();
}
Метод getConnection() делает попытку соединиться с роботом и возвращает установленное соединение,
через которое можно отдавать роботу команды.

Установка соединения может завершиться неуспешно, а также уже установленное соединение может внезапно разорваться.
Всякое бывает. Поэтому любой метод RobotConnectionManager и RobotConnection может бросить непроверяемое исключение
RobotConnectionException:

public class RobotConnectionException extends RuntimeException {

    public RobotConnectionException(String message) {
        super(message);

    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
Ваша задача - реализовать метод который устанавливает соединение с роботом, отдает ему команду на перемещение в
заданную точку и затем закрывает соединение, выполняя при необходимости повтор этой последовательности до трех раз.

При этом:

Попытка отдать команду роботу считается успешной, если удалось установить соединение и выполнить метод
RobotConnection.moveRobotTo() без исключений. Ошибка закрытия соединения не важна и должна игнорироваться.

Если первая попытка подключиться и отдать команду оказалась неуспешной, то закрываем соединение и выполняем
вторую попытку. Если вторая тоже не удалась, то выполняется третья. После третьей неудачи метод должен бросить
исключение RobotConnectionException.

Метод отвечает за открытие и закрытие соединения. Если соединение удалось установить, то оно обязательно должно
быть закрыто несмотря на возможные исключения, случившиеся в дальнейшем во время работы метода.

Если во время работы метода случилось исключение любого типа, отличного от RobotConnectionException, метод должен
завершиться и выбросить это исключение, не выполняя повторных попыток пообщаться с роботом. Единственное, что метод
должен сделать перед выбросом этого исключения — закрыть открытое соединение RobotConnection.

В решение должен использоваться классический try-catch.
*/

public class JavaCore_4_2_8 {

    public static void main(String[] args) {

    }

    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);

        @Override
        void close();
    }

    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    public static class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);
        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }


    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {

        RobotConnection connection = null;

        for (int i = 0; i < 3; i++) {
            try {

                connection = robotConnectionManager.getConnection();
                connection.moveRobotTo(toX, toY);
                i = 3;

            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw new RobotConnectionException("Ахтунг");
                }

            } catch (RuntimeException e) {
                throw new RuntimeException("Ахтунг");

            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (RobotConnectionException e) {

                    }
                }
            }
        }
    }
}

/*
- Подключение к роботу представляется в программе интерфейсом RobotConnection
стал понимать команду на перемещение в заданную точку (метод moveRobotTo)

- RobotConnection - это временно устанавливаемое соединение, которое надо закрывать,
когда оно больше не нужно. Для закрытия соединения в интерфейсе есть метод close().

- За установку соединения отвечает RobotConnectionManager
Метод getConnection() делает попытку соединиться с роботом и возвращает установленное соединение,
через которое можно отдавать роботу команды.


- Установить соединение с роботом
- Отдает ему команду на перемещение в заданную точку
- Закрывает соединение

при необходимости повтор этой последовательности до трех раз

- Попытка отдать команду роботу считается успешной, если удалось установить соединение и выполнить метод
RobotConnection.moveRobotTo() без исключений. Ошибка закрытия соединения не важна и должна игнорироваться.
- Если первая попытка подключиться и отдать команду оказалась неуспешной, то закрываем соединение и выполняем
вторую попытку. Если вторая тоже не удалась, то выполняется третья. После третьей неудачи метод должен бросить
исключение RobotConnectionException.

- Если соединение удалось установить, то оно обязательно должно быть закрыто

- Если во время работы метода случилось исключение любого типа, отличного от RobotConnectionException,
метод должен завершиться и выбросить это исключение, не выполняя повторных попыток пообщаться с роботом.
Единственное, что метод должен сделать перед выбросом этого исключения — закрыть открытое соединение RobotConnection.
*/