
package com.mzh.annotation;

import java.lang.annotation.*;
import org.springframework.stereotype.Component;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface ElasticSimpleJob {

	String corn() default "0 0/1 * * * ?";

	boolean disabled() default true;

	boolean overwrite() default false;

	int shardingTotalCount() default 1;

	String shardingItemParameters() default "0=0";

}
