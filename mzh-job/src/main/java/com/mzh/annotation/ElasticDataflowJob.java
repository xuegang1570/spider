package com.mzh.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Component;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface ElasticDataflowJob {

	String corn() default "0 0/1 * * * ?";

	boolean disabled() default true;

	int shardingTotalCount() default 1;

	String shardingItemParameters() default "0=0";

	boolean overwrite() default true;

	boolean streamingProcess() default true;

}