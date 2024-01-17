//: jdbc.config.AppConfig.java


package jdbc.config;


import com.zaxxer.hikari.HikariDataSource;
import jdbc.domain.model.Account;
import jdbc.domain.model.Purchase;
import jdbc.repository.AccountRowMapper;
import jdbc.repository.PurchaseRowMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = {
        "jdbc.repository",
        "jdbc.service",
        "jdbc.controller",
        "jdbc.controller.advice"})
class AppConfig {

    @Value("${yul.datasource.url}")
    private String datasourceUrl;

    @Value("${yul.datasource.username}")
    private String datasourceUsername;

    @Value("${yul.datasource.password}")
    private String datasourcePassword;

    @Value("${yul.datasource.connection-timeout}")
    private long datasourceConnectionTimeout;


    @Bean
    RowMapper<Purchase> purchaseRowMapper() {
        return new PurchaseRowMapper();
    }

    @Bean
    RowMapper<Account> accountRowMapper() {
        return new AccountRowMapper();
    }

    @Bean
    DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(datasourceUrl);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);
        dataSource.setConnectionTimeout(datasourceConnectionTimeout);
        return dataSource;
    }

}///:~