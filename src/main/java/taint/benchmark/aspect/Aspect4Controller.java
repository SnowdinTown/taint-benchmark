package taint.benchmark.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import taint.benchmark.sinks.SinkMethod;

@Aspect
public class  Aspect4Controller {

    @Pointcut("execution(public * taint.benchmark.controller.TestController4.test10(..))")
    public void pointcut1() {
    }

    @Pointcut("execution(public * taint.benchmark.controller.TestController4.test11(..))")
    public void pointcut2() {
    }

    @Pointcut("execution(public * taint.benchmark.controller.TestController4.test15(..))")
    public void pointcut3() {
    }

    @Around("pointcut1()")
    public Object aroundMethod1(ProceedingJoinPoint joinPoint) throws Throwable {
        SinkMethod.sink_10(joinPoint.getArgs()[0]);
        SinkMethod.sink_10(joinPoint.getArgs()[1]);
        SinkMethod.sink_10(joinPoint.getArgs());
        return joinPoint.proceed();
    }

    @Before("pointcut1()")
    public void beforeMethod1(JoinPoint joinPoint){
        SinkMethod.sink_10(joinPoint.getArgs()[0]);
        SinkMethod.sink_10(joinPoint.getArgs()[1]);
        SinkMethod.sink_10(joinPoint.getArgs());
    }

    @After("pointcut1()")
    public void afterMethod1(JoinPoint joinPoint){
        SinkMethod.sink_10(joinPoint.getArgs()[0]);
        SinkMethod.sink_10(joinPoint.getArgs()[1]);
        SinkMethod.sink_10(joinPoint.getArgs());
    }

    @AfterReturning(value = "pointcut1()", returning = "result")
    public void afterReturningMethod1(JoinPoint joinPoint, Object result) {
        SinkMethod.sink_10(joinPoint.getArgs()[0]);
        SinkMethod.sink_10(joinPoint.getArgs()[1]);
        SinkMethod.sink_10(joinPoint.getArgs());
    }

    @AfterThrowing(value = "pointcut1()", throwing = "e")
    public void afterThrowingMethod1(JoinPoint joinPoint, Exception e) {
        SinkMethod.sink_10(joinPoint.getArgs()[0]);
        SinkMethod.sink_10(joinPoint.getArgs()[1]);
        SinkMethod.sink_10(joinPoint.getArgs());
    }

    @Around("pointcut2()")
    public Object aroundMethod2(ProceedingJoinPoint joinPoint) throws Throwable {
        Object o = joinPoint.proceed();
        SinkMethod.sink_11(o);
        return o;
    }

    @AfterReturning(value = "pointcut2()", returning = "result")
    public void afterReturningMethod2(JoinPoint joinPoint, Object result) {
        SinkMethod.sink_11(result);
    }

    @Around("pointcut3()")
    public Object aroundMethod3(ProceedingJoinPoint joinPoint) throws Throwable {
        Object o = joinPoint.proceed();
        SinkMethod.sink_15(o);
        return o;
    }

}
