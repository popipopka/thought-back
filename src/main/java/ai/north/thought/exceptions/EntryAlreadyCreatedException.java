package ai.north.thought.exceptions;

/**
 * Ошибка, показывающая, что запись в бд уже существует
 */
public class EntryAlreadyCreatedException extends Exception {
    public EntryAlreadyCreatedException(String message) {
        super(message);
    }
}
