//: jdbc.domain.model.AccountErrors.java


package jdbc.domain.model;


import lombok.NonNull;


public record AccountError(long accountId, String errorMsg) {

    public static AccountError of(
            final long accountId, @NonNull final String errorMsg) {

        return new AccountError(accountId, errorMsg);
    }

}///:~