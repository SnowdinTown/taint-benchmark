package taint.benchmark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import taint.benchmark.domain.TestBean3;
import taint.benchmark.domain.TestBean4;
import taint.benchmark.model.TestParam;
import taint.benchmark.service.TestService6;
import taint.benchmark.sinks.SinkMethod;

@Service("testService6Impl2")
@Scope("prototype")
public class TestService6Impl2 implements TestService6 {

    @Autowired
    private TestBean3 testBean3;

    @Autowired
    private TestBean4 testBean4;

    @Override
    public void setTaintParam(TestParam param) {
        testBean3.setTaintParam(param);
        testBean4.setTaintParam(param);
    }

    @Override
    public void sinkCall1() {
        SinkMethod.sink_9(testBean3.getTaintParam());
    }

    @Override
    public void sinkCall2() {
        SinkMethod.sink_9(testBean4.getTaintParam());
    }
}
