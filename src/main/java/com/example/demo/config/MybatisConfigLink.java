package com.example.demo.config;


import com.example.demo.jdbc.DataSourceProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class MybatisConfigLink {

    public static final String NAME = "link";
    public static final String PREFIX = "database." + NAME;

    //@Primary
    @Bean(name = NAME + "DataSource")
    public DataSource linkDataSource() {
        return linkDataSourceProperties().generateDatasource();
    }

    @Bean
    @ConfigurationProperties(prefix = PREFIX)
    public DataSourceProperties linkDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = NAME + "SqlSessionFactory")
    public SqlSessionFactory coreCommonSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(linkDataSource());
        bean.setTypeAliasesPackage(MybatisMapperScannerConfig.BASE_PACKAGE_LINK);

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(MybatisMapperScannerConfig.MAPPER_LOCATION_LINK));
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
