//: jdbc.repository.PurchaseRowMapper.java


package jdbc.repository;


import jdbc.domain.model.Purchase;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PurchaseRowMapper implements RowMapper<Purchase> {

    @Override
    public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {

        Purchase rowObj = new Purchase();

        rowObj.id(rs.getInt("id"));
        rowObj.product(rs.getString("product"));
        rowObj.price(rs.getLong("price"));

        return rowObj;
    }

}///:~