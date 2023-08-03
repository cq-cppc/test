package com.edu.cqupt.bigdata.RiskFactorExcavation.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.edu.cqupt.bigdata.RiskFactorExcavation.dao.data",sqlSessionTemplateRef = "dataTableSqlSessionTemplate")
public class MybatisDataTableConfig {

    @Bean("dataTableSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataTableDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(
                        "classpath:mapper/data/*.xml")
        );
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("dataTableSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("dataTableSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("dataTableDataSourceTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("dataTableDataSource") DataSource dataSource){
        DataSourceTransactionManager manager=new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }

}
