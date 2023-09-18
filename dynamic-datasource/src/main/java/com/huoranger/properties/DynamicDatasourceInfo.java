package com.huoranger.properties;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Component
@ConfigurationProperties(prefix = "huoranger.datasource")
@Data
@Slf4j
public class DynamicDatasourceInfo extends HikariDataSource {

    private Map<String, HikariDataSource> dynamicDatasource;

    private String url;
    private String driverClassName;
    private String username;
    private String password;

    @PostConstruct
    public void init() {
        log.info("数据源配置读取完成{}", dynamicDatasource.keySet());
        super.setJdbcUrl(url);
        super.setUsername(username);
        super.setPassword(password);
        super.setDriverClassName(driverClassName);
    }

}
