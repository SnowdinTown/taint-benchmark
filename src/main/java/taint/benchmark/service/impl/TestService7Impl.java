package taint.benchmark.service.impl;

import org.springframework.stereotype.Service;
import taint.benchmark.model.TestParam;
import taint.benchmark.service.TestService7;
import taint.benchmark.sinks.SinkMethod;

@Service
public class TestService7Impl implements TestService7 {
    @Override
    public void sinkCall(TestParam param, int i) {
        SinkMethod.sink_12(param);
    }

    @Override
    public TestParam sinkCall(TestParam param) {
        SinkMethod.sink_13(param);
        return param;
    }
}
