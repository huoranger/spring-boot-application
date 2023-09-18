package com.huoranger.aspect;

import com.huoranger.annotation.Datasource;
import com.huoranger.enums.DatasourceEnum;
import com.huoranger.utils.DatasourceContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
@Slf4j
public class DatasourceAspect {

    @Around("@annotation(datasource)")
    public Object handleDatasource(ProceedingJoinPoint joinPoint, Datasource datasource) throws Throwable {
        String datasourceName = datasource.value().name();
        if (StringUtils.hasText(datasourceName) && !DatasourceEnum.DEFAULT.equals(datasource.value())) {
            DatasourceContext.setDataSourceType(datasourceName.toLowerCase());
        }
        try {
            return joinPoint.proceed();
        } finally {
            DatasourceContext.clearDataSourceType();
        }
    }

}
