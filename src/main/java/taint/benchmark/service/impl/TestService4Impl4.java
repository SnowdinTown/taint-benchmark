package taint.benchmark.service.impl;

import org.springframework.stereotype.Service;
import taint.benchmark.model.TestParam;
import taint.benchmark.sinks.SinkMethod;

@Service("testService4Impl4")
public class TestService4Impl4 extends TestService4Impl2{
    @Override
    public void sinkCall(TestParam param) {
        SinkMethod.sink_6(param);
    }
}
