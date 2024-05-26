package ai.north.thought.controllers.handlers;

import ai.north.thought.dto.basic.ErrorMessageDTO;
import ai.north.thought.exceptions.EntryAlreadyCreatedException;
import ai.north.thought.exceptions.EntryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionsHandler {
    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> handleEntryNotFoundException(EntryNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageDTO(e.getMessage()));
    }

    @ExceptionHandler(EntryAlreadyCreatedException.class)
    public ResponseEntity<ErrorMessageDTO> handleEntryAlreadyCreatedException(EntryAlreadyCreatedException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorMessageDTO(e.getMessage()));
    }
}
