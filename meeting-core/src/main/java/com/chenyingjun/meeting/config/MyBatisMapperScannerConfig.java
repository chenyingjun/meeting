package com.chenyingjun.meeting.config;

/**
 * MyBatis扫描接口
 *
 * @author chenyingjun
 * @version 2017年05月09日
 * @since 1.0
 */
//@Configuration
//注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
//@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        mapperScannerConfigurer.setBasePackage("com.chenyingjun.meeting.mapper");
//        return mapperScannerConfigurer;
//    }

}