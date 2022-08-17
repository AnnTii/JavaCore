package Exceptions;

/*
Реши предыдущую задачу с использованием try-with-resources
*/

public class JavaCore_4_2_9 {

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

        for (int i = 0; i < 3; i++) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {

                connection.moveRobotTo(toX, toY);
                i = 3;

            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw new RobotConnectionException("Ахтунг");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("Ахтунг");

            }
        }
    }
}
