//: jdbc.repository.PurchaseRepository.java


package jdbc.repository;


import jdbc.domain.model.Purchase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PurchaseRepository {

    String SQL_SAVE_PURCHASE_TEMPLATE = "INSERT INTO purchase (product, price) VALUES (?, ?)";
    String SQL_FETCH_ALL_PURCHASES = "SELECT * FROM purchase";

    void save(Purchase purchase);

    List<Purchase> findAll();
}


@Slf4j
@Repository
@RequiredArgsConstructor
class PurchaseRepositoryImpl implements PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Purchase> purchaseRowMapper;

    @Override
    public void save(@NonNull final Purchase purchase) {

        int count = jdbcTemplate.update(
                SQL_SAVE_PURCHASE_TEMPLATE,
                purchase.product(),
                purchase.price());

        if (count < 1) {
            log.error(">>> Failed to save Purchase : {}", purchase);
        }
    }

    @Override
    public List<Purchase> findAll() {
        return jdbcTemplate.query(SQL_FETCH_ALL_PURCHASES, this.purchaseRowMapper);
    }

}

///:~