package taint.benchmark.service;

import taint.benchmark.model.TestParam;

public interface TestService6 {

    void setTaintParam(TestParam param);

    void sinkCall1();

    void sinkCall2();
}
