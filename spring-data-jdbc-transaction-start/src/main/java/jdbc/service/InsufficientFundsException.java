//: jdbc.service.InsufficientFundsException.java


package jdbc.service;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;


@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor(staticName = "of")
public class InsufficientFundsException extends RuntimeException {

    private final long accountId;

}///:~