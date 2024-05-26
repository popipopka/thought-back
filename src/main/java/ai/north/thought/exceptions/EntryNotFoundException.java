package ai.north.thought.exceptions;

/**
 * Ошибка, показывающая, что записи в бд не существует
 */
public class EntryNotFoundException extends Exception {
    public EntryNotFoundException(String message) {
        super(message);
    }
}
