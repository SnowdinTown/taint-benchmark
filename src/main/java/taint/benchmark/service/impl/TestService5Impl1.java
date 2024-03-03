package taint.benchmark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import taint.benchmark.domain.TestBean;
import taint.benchmark.domain.TestBean1;
import taint.benchmark.domain.TestBean2;
import taint.benchmark.service.TestService5;
import taint.benchmark.sinks.SinkMethod;

@Service("testService5Impl1")
public class TestService5Impl1 implements TestService5 {

    @Autowired
    private TestBean1 testBean1;

    @Autowired
    private TestBean2 testBean2;

    @Override
    public void sinkCall1() {
        SinkMethod.sink_7(testBean1.getTaintParam());
    }

    @Override
    public void sinkCall2() {
        SinkMethod.sink_7(testBean2.getTaintParam());
    }
}
