//: jdbc.repository.AccountRowMapper.java


package jdbc.repository;


import jdbc.domain.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Account.of(rs.getInt("id"),
                rs.getString("name"),
                rs.getLong("amount"));
    }

}///:~