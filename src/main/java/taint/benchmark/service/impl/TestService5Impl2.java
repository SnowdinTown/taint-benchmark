package taint.benchmark.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import taint.benchmark.domain.TestBean;
import taint.benchmark.domain.TestBean1;
import taint.benchmark.domain.TestBean2;
import taint.benchmark.service.TestService5;
import taint.benchmark.sinks.SinkMethod;

@Service("testService5Impl2")
public class TestService5Impl2 implements TestService5 {

    private TestBean1 testBean1;
    private TestBean2 testBean2;

    public TestService5Impl2(TestBean1 bean1, TestBean2 bean2) {
        testBean1 = bean1;
        testBean2 = bean2;
    }

    @Override
    public void sinkCall1() {
        SinkMethod.sink_7(testBean1.getTaintParam());
    }

    @Override
    public void sinkCall2() {
        SinkMethod.sink_7(testBean2.getTaintParam());
    }
}
