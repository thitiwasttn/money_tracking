package com.thitiwas.money_tracking.core.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
// @EnableJpaRepositories(value = "com.g_able.enb.eco_me.member", enableDefaultTransactions = false)
public class DatabaseConfiguration {

    /*@Bean
    public DataSource restDataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://61.19.242.56:3304/e_co_me_member");
        dataSource.setUsername("thitiwas");
        dataSource.setPassword("P@ssw0rd");

        return dataSource;

    }*/
}
