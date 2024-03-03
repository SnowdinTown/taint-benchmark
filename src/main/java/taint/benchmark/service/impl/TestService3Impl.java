package taint.benchmark.service.impl;

import taint.benchmark.model.TestParam;
import taint.benchmark.service.TestService3;
import taint.benchmark.sinks.SinkMethod;

public class TestService3Impl implements TestService3 {
    @Override
    public void sinkCall(TestParam param) {
        SinkMethod.sink_5(param);
    }
}
