//: jdbc.service.AccountNotFoundException.java


package jdbc.service;


public class AccountNotFoundException extends RuntimeException {

    private final long id;

    public AccountNotFoundException(long id) {
        super();
        this.id = id;
    }

    public long id() {
        return id;
    }

}///:~