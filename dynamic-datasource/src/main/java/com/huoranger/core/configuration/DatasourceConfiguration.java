package com.huoranger.configuration;

import com.huoranger.handler.DynamicDatasourceHandler;
import com.huoranger.properties.DynamicDatasourceInfo;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatasourceConfiguration {

    @Resource
    private DynamicDatasourceInfo dynamicDatasourceInfo;



    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDatasourceHandler dynamicDatasourceHandler() {
        return new DynamicDatasourceHandler(dynamicDatasourceInfo, dynamicDatasourceInfo.getDynamicDatasource());
    }

}
