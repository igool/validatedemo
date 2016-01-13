package validatedemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import validatedemo.exception.ValidatorException;
import validatedemo.util.ApplicationContextUtils;
import validatedemo.util.ErrorHelper;

/**
 * 类描述:AOP拦截验证.
 **/
@Aspect
@Component
@Order(102)
public class ValidateHandelAspect {

    @Before("validatePointcut()") 
    public void validateAround(JoinPoint joinPoint) throws Throwable  {  
        Object[] args =  joinPoint.getArgs();
        BindingResult bindingResult = null;
        if (args != null) {
            for (Object obj : args) {
                if (obj instanceof BindingResult) {
                    bindingResult = (BindingResult) obj;
                    break;
                }
            }
        }
        if ( bindingResult != null && bindingResult.hasErrors() ){
//            joinPoint.getSignature();
//            joinPoint.getTarget() ;
            /*if ( ){
                
            }*/
            throw new ValidatorException("验证异常", ((ErrorHelper)ApplicationContextUtils.getApplicationContext().getBean("errorHelper")).converBindError2AjaxError(bindingResult));
        }
    }
    
    @Pointcut("@annotation(validatedemo.aop.ValidateEntry)")
    public void validatePointcut() {
        
    }
}
