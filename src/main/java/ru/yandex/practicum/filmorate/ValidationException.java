package ru.yandex.practicum.filmorate;

public class ValidationException extends Exception {
        public ValidationException() {
        }
        public ValidationException(String message) {
            super(message);
        }
}
