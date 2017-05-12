package com.chenyingjun.meeting.druid;

/**
 * 数据库连接
 *
 * @author chenyingjun
 * @version 2017年05月05日
 * @since 1.0
 */
//@Configuration
//@EnableConfigurationProperties(DruidProperties.class)
//@ConditionalOnClass(DruidDataSource.class)
//@ConditionalOnProperty(prefix = "druid", name = "url")
//@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoConfiguration {
//
//    @Autowired
//    private DruidProperties properties;
//
//    @Bean
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(properties.getUrl());
//        dataSource.setUsername(properties.getUsername());
//        dataSource.setPassword(properties.getPassword());
//        if (properties.getInitialSize() > 0) {
//            dataSource.setInitialSize(properties.getInitialSize());
//        }
//        if (properties.getMinIdle() > 0) {
//            dataSource.setMinIdle(properties.getMinIdle());
//        }
//        if (properties.getMaxActive() > 0) {
//            dataSource.setMaxActive(properties.getMaxActive());
//        }
//        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
//        try {
//            dataSource.init();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return dataSource;
//    }
}
