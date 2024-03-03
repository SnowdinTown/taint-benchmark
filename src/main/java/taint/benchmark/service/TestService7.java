package taint.benchmark.service;

import taint.benchmark.model.TestParam;

public interface TestService7 {

    void sinkCall(TestParam param, int i);

    TestParam sinkCall(TestParam param);
}
