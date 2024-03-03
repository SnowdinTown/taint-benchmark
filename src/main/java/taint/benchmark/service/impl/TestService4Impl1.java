package taint.benchmark.service.impl;

import org.springframework.stereotype.Service;
import taint.benchmark.model.TestParam;
import taint.benchmark.service.TestService4;
import taint.benchmark.sinks.SinkMethod;

@Service("testService4Impl1")
public class TestService4Impl1 implements TestService4 {
    @Override
    public void sinkCall(TestParam param) {
        SinkMethod.sink_6(param);
    }
}
