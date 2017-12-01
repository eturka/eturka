package ru.job4j.tracker;

/**
 * Class MenuOutException.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 01.12.2017
 */
class MenuOutException extends RuntimeException {
    /**
     * Constructs a new MenuOutException exception with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    MenuOutException(String message) {
        super(message);
    }
}
