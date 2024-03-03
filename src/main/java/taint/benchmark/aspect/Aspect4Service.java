package taint.benchmark.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import taint.benchmark.sinks.SinkMethod;

@Aspect
@Component
public class Aspect4Service {
    @Pointcut("execution(public * taint.benchmark.service.TestService7.sinkCall(taint.benchmark.model.TestParam,int))")
    public void pointcut1() {
    }

    @Pointcut("execution(public * taint.benchmark.service.TestService7.sinkCall(taint.benchmark.model.TestParam))")
    public void pointcut2() {
    }

    @Around("pointcut1()")
    public Object aroundMethod1(ProceedingJoinPoint joinPoint) throws Throwable {
        SinkMethod.sink_12(joinPoint.getArgs()[0]);
        SinkMethod.sink_12(joinPoint.getArgs()[1]);
        return joinPoint.proceed();
    }

    @Before("pointcut1()")
    public void beforeMethod1(JoinPoint joinPoint){
        SinkMethod.sink_12(joinPoint.getArgs()[0]);
        SinkMethod.sink_12(joinPoint.getArgs()[1]);
    }

    @After("pointcut1()")
    public void afterMethod1(JoinPoint joinPoint){
        SinkMethod.sink_12(joinPoint.getArgs()[0]);
        SinkMethod.sink_12(joinPoint.getArgs()[1]);
    }

    @AfterReturning(value = "pointcut1()", returning = "result")
    public void afterReturningMethod1(JoinPoint joinPoint, Object result) {
        SinkMethod.sink_12(joinPoint.getArgs()[0]);
        SinkMethod.sink_12(joinPoint.getArgs()[1]);
    }

    @AfterThrowing(value = "pointcut1()", throwing = "e")
    public void afterThrowingMethod1(JoinPoint joinPoint, Exception e) {
        SinkMethod.sink_12(joinPoint.getArgs()[0]);
        SinkMethod.sink_12(joinPoint.getArgs()[1]);
    }

    @Around("pointcut2()")
    public Object aroundMethod2(ProceedingJoinPoint joinPoint) throws Throwable {
        Object o = joinPoint.proceed();
        SinkMethod.sink_13(o);
        return o;
    }

    @AfterReturning(value = "pointcut2()", returning = "result")
    public void afterReturningMethod2(JoinPoint joinPoint, Object result) {
        SinkMethod.sink_13(result);
    }
}
