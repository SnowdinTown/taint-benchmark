package taint.benchmark.service.impl;

import taint.benchmark.model.TestParam;
import taint.benchmark.service.TestService2;
import taint.benchmark.sinks.SinkMethod;

public class TestService2Impl implements TestService2 {
    @Override
    public void sinkCall(TestParam param) {
        SinkMethod.sink_5(param);
    }
}
