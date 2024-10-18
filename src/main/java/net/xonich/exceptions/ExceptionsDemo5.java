package net.xonich.exceptions;

import java.util.NoSuchElementException;

public class ExceptionsDemo5 {
    public static void main(String[] args) {
        getUserName();
    }

    public static String getUserName() {
        try {
            return getQueryResult("select * from users");
        }  catch (NoSuchElementException|ArithmeticException e) {
            throw new BusinessException("Ошибка при запросе имени пользователя", e);
        } catch (IllegalStateException e) {
            throw new InfrastructureException("Система недоступна", e);
        }
    }

    public static String getQueryResult(String query) {

        if (Math.random() > 0.1) {
            if (Math.random() > 0.5) {
                throw new IllegalStateException("БД недоступна");
            }
            throw new NoSuchElementException();
        }
        return "Vasya";
    }
}
