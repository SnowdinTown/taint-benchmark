package taint.benchmark.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import taint.benchmark.domain.TestBean;
import taint.benchmark.service.TestService5;
import taint.benchmark.sinks.SinkMethod;

@Service("testService5Impl4")
public class TestService5Impl4 implements TestService5 {

    private TestBean testBean1;
    private TestBean testBean2;

    public TestService5Impl4(@Qualifier("testBean1")TestBean bean1, @Qualifier("testBean2")TestBean bean2) {
        testBean1 = bean1;
        testBean2 = bean2;
    }

    @Override
    public void sinkCall1() {
        SinkMethod.sink_8(testBean1.getTaintParam());
    }

    @Override
    public void sinkCall2() {
        SinkMethod.sink_8(testBean2.getTaintParam());
    }
}
