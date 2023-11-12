package org.javaboy.platform.adapter.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author:majin.wj
 */
@Aspect
@Component
public class HttpRequestAspect {

    @Pointcut("execution(public * org.javaboy.platform.adapter.controller..*(..))")
    public void pointCut(){}

}
