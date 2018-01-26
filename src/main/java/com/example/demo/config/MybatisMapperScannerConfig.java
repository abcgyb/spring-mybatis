package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * 任务：
 * 描述：Mapper扫描配置文件
 *
 * @version 1.0
 */
@Configuration
public class MybatisMapperScannerConfig {

    public static final String BASE_PACKAGE_LINK = "com.example.demo.mapper.business";
    public static final String MAPPER_LOCATION_LINK = "classpath*:mapper/business/**/*Mapper*.xml";

    public static final String BASE_PACKAGE_LOCAL = "com.example.demo.mapper.local";
    public static final String MAPPER_LOCATION_LOCAL = "classpath*:mapper/local/**/*Mapper*.xml";
    private static final String SQL_SESSION_FACTORY = "SqlSessionFactory";

    @Bean
    public MapperScannerConfigurer linkDatabaseMapperScannerConfig() {
        MapperScannerConfigurer mapperScannerConfigurer = getMapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(MybatisConfigLink.NAME + SQL_SESSION_FACTORY);
        mapperScannerConfigurer.setBasePackage(BASE_PACKAGE_LINK);
        return mapperScannerConfigurer;
    }
    @Bean
    public MapperScannerConfigurer localDatabaseMapperScannerConfig() {
        MapperScannerConfigurer mapperScannerConfigurer = getMapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(MybatisConfigLocal.NAME + SQL_SESSION_FACTORY);
        mapperScannerConfigurer.setBasePackage(BASE_PACKAGE_LOCAL);
        return mapperScannerConfigurer;
    }



    private MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        MapperHelper mapperHelper = new MapperHelper();
        mapperHelper.registerMapper(MySqlMapper.class);
        mapperHelper.registerMapper(Mapper.class);
        mapperScannerConfigurer.setMapperHelper(mapperHelper);
        Properties properties = new Properties();
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }

}

