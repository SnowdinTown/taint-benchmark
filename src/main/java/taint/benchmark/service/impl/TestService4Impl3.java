package taint.benchmark.service.impl;

import org.springframework.stereotype.Service;
import taint.benchmark.model.TestParam;
import taint.benchmark.sinks.SinkMethod;

@Service("testService4Impl3")
public class TestService4Impl3 extends TestService4Impl1{
    @Override
    public void sinkCall(TestParam param) {
        SinkMethod.sink_6(new TestParam());
    }
}
