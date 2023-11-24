package org.javaboy.platform.adapter.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.javaboy.common.utils.PlatformResult;
import org.javaboy.common.utils.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.management.PlatformLoggingMXBean;

/**
 * @author:majin.wj
 */
@Aspect
@Component
public class HttpRequestAspect {

    private static Logger LOG = LoggerFactory.getLogger(HttpRequestAspect.class);

    @Pointcut("execution(public * org.javaboy.platform.adapter.controller..*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        PlatformResult result = null;
        try {
            result = (PlatformResult) joinPoint.proceed();
        } catch (BizException e) {
            LOG.error("Controller接口业务异常", e);
            result = PlatformResult.fail(e.getCode(), e.getMessage());
        } catch (Throwable e) {
            LOG.error("Controller接口系统异常", e);
            result = PlatformResult.fail("SystemError", "system error " + e.getMessage());
        }
        return result;
    }

}
