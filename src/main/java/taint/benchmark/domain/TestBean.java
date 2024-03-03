package taint.benchmark.domain;

import org.springframework.stereotype.Component;
import taint.benchmark.model.TestParam;

public class TestBean {
    private TestParam taintParam;

    public void setTaintParam(TestParam taintParam) {
        this.taintParam = taintParam;
    }

    public TestParam getTaintParam() {
        return taintParam;
    }
}
