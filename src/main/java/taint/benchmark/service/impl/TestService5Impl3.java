package taint.benchmark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import taint.benchmark.domain.TestBean;
import taint.benchmark.service.TestService5;
import taint.benchmark.sinks.SinkMethod;

@Service("testService5Impl3")
public class TestService5Impl3 implements TestService5 {

    @Autowired
    @Qualifier("testBean1")
    private TestBean testBean1;

    @Autowired
    @Qualifier("testBean2")
    private TestBean testBean2;

    @Override
    public void sinkCall1() {
        SinkMethod.sink_8(testBean1.getTaintParam());
    }

    @Override
    public void sinkCall2() {
        SinkMethod.sink_8(testBean2.getTaintParam());
    }
}
