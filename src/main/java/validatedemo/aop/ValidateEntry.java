
package validatedemo.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类描述:启用验证的注解.
 **/
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)
public @interface  ValidateEntry {

    /**
     * 描述定义
     * **/
    public String desc() default "" ; 
}
