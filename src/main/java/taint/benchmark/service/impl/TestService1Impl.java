package taint.benchmark.service.impl;

import org.springframework.stereotype.Service;
import taint.benchmark.model.TestParam;
import taint.benchmark.service.TestService1;
import taint.benchmark.sinks.SinkMethod;

@Service
public class TestService1Impl implements TestService1 {

    @Override
    public void sinkCall(TestParam param) {
        SinkMethod.sink_5(param);
    }

}
