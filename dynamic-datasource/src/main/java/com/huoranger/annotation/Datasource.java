package com.huoranger.annotation;

import com.huoranger.enums.DatasourceEnum;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Datasource {
    public DatasourceEnum value() default DatasourceEnum.DEFAULT;
}
