//: jdbc.service.TransferService.java


package jdbc.service;


import com.google.common.collect.ImmutableList;
import jdbc.domain.model.Account;
import jdbc.domain.model.TransferRequestDto;
import jdbc.repository.AccountRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AccountTransferService {
    List<Account> allAccounts();
    Account findAccountById(long id);
    List<Account> findAccountByName(String name);
    List<Account> transferMoney(TransferRequestDto transRequest);
}

@Service
@RequiredArgsConstructor
class AccountTransferServiceImpl implements AccountTransferService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> allAccounts() {
        return ImmutableList.copyOf(this.accountRepository.findAll());
    }

    @Override
    public Account findAccountById(long id) {
        return this.accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    @Override
    public List<Account> findAccountByName(@NonNull final String name) {
        return this.accountRepository.findAccountsByName(name);
    }

    @Override
    @Transactional
    public List<Account> transferMoney(
            @NonNull final TransferRequestDto transRequest) {

        long senderAccountId = transRequest.senderAccountId();
        long receiverAccountId = transRequest.receiverAccountId();

        final var sender = this.findAccount(senderAccountId);
        final var receiver = this.findAccount(receiverAccountId);

        long senderNewAmount = sender.amount() - transRequest.amount();

        if (senderNewAmount < 0) {
            throw InsufficientFundsException.of(senderAccountId);
        }

        long receiverNewAmount = receiver.amount() + transRequest.amount();

        accountRepository.changeAmount(senderAccountId, senderNewAmount);
        accountRepository.changeAmount(receiverAccountId, receiverNewAmount);

        return List.of(
                this.findAccount(senderAccountId),
                this.findAccount(receiverAccountId));
    }
    private Account findAccount(long id) {

        Optional<Account> accountOpt = accountRepository.findById(id);

        return accountOpt.orElseThrow(
                () -> new AccountNotFoundException(id));
    }

}

///:~