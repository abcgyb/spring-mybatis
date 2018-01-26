package com.example.demo.config;


import com.example.demo.jdbc.DataSourceProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class MybatisConfigLocal {

    public static final String NAME = "local";
    public static final String PREFIX = "database." + NAME;

    @Primary
    @Bean(name = "localDataSource")
    public DataSource localDataSource() {
        return localDataSourceProperties().generateDatasource();
    }


    @Bean
    @ConfigurationProperties(prefix = PREFIX)
    public DataSourceProperties localDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = NAME + "SqlSessionFactory")
    public SqlSessionFactory coreCommonSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(localDataSource());
        bean.setTypeAliasesPackage(MybatisMapperScannerConfig.BASE_PACKAGE_LOCAL);

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(MybatisMapperScannerConfig.MAPPER_LOCATION_LOCAL));
        SqlSessionFactory sqlSessionFactory = bean.getObject();
        specialTypeHandlerRegistry(sqlSessionFactory);
        return sqlSessionFactory;
    }

    //特殊类型的处理Handler注册
    private void specialTypeHandlerRegistry(SqlSessionFactory sqlSessionFactory) {
        TypeHandlerRegistry typeHandlerRegistry = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry();
/*        typeHandlerRegistry.register(HospitalizationEqualMode.class, JdbcType.TINYINT, EnumOrdinalTypeHandler.class);
        typeHandlerRegistry.register(HospitalizationRuleMode.class, JdbcType.TINYINT, EnumOrdinalTypeHandler.class);*/
    }

    @Bean(name = NAME + "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(coreCommonSqlSessionFactoryBean());
    }

}
