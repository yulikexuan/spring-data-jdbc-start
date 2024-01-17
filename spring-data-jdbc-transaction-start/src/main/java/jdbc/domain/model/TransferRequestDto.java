//: jdbc.domain.model.TransferRequestDto.java


package jdbc.domain.model;


public record TransferRequestDto(
        long senderAccountId, long receiverAccountId, long amount) {

}///:~