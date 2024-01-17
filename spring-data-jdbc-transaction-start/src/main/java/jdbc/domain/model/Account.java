//: jdbc.domain.model.Account.java


package jdbc.domain.model;


import lombok.NonNull;
import org.springframework.data.annotation.Id;


public record Account(@Id long id, String name, long amount) {

    public static Account of(
            final long id, @NonNull final String name, final long amount) {

        return new Account(id, name, amount);
    }

}///:~