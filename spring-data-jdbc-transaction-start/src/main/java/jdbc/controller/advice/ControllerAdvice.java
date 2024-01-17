//: jdbc.controller.advice.ControllerAdvice.java


package jdbc.controller.advice;


import jdbc.domain.model.AccountError;
import jdbc.domain.model.UnknownError;
import jdbc.service.AccountNotFoundException;
import jdbc.service.InsufficientFundsException;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(AccountNotFoundException.class)
    ResponseEntity<AccountError> handleAccountNotFoundError(
            @NonNull final AccountNotFoundException e) {

        var error = AccountError.of(e.id(),
                ">>> The account of id %d not exists!".formatted(e.id()));

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    ResponseEntity<AccountError> handleInsufficientFundsError(
            @NonNull final InsufficientFundsException e) {
        final var id = e.accountId();
        var error = AccountError.of(id,
                ">>> Account of id %d has no sufficient funds to do the transaction!"
                        .formatted(id));
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<UnknownError> handleUnknownError(RuntimeException e) {

        e.printStackTrace();

        return ResponseEntity.internalServerError().body(
                new UnknownError(">>> Something went wrong!!"));
    }

}///:~