package taint.benchmark.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import taint.benchmark.sinks.SinkMethod;

@Aspect
@Component
public class Aspect4Controller2 {
    @Pointcut("execution(public * taint.benchmark.controller.TestController4.test15(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object o = joinPoint.proceed();
        SinkMethod.sink_15(o);
        return o;
    }
}
