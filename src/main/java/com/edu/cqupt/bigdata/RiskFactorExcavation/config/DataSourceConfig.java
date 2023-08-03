package com.edu.cqupt.bigdata.RiskFactorExcavation.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "mysqlDataSourceProperties")
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSourceProperties mysqlDataSourceProperties(){
        return new DataSourceProperties();
    }


    @Primary
    @Bean(name = "mysqlDataSource")
    public DataSource mysqlDataSource(@Qualifier("mysqlDataSourceProperties") DataSourceProperties factoryProperties){
        factoryProperties.setType(HikariDataSource.class);
        return factoryProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "dataTableDataSourceProperties")
    @ConfigurationProperties("spring.datasource.data.table")
    public DataSourceProperties dataTableDataSourceProperties(){
        return new DataSourceProperties();
    }


    @Bean(name = "dataTableDataSource")
    public DataSource dataTableDataSource(@Qualifier("dataTableDataSourceProperties") DataSourceProperties factoryProperties){
        factoryProperties.setType(HikariDataSource.class);
        return factoryProperties.initializeDataSourceBuilder().build();
    }

}
