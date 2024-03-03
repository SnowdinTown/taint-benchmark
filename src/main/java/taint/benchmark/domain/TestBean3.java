package taint.benchmark.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import taint.benchmark.model.TestParam;

@Component
public class TestBean3 {
    private TestParam taintParam;

    public void setTaintParam(TestParam taintParam) {
        this.taintParam = taintParam;
    }

    public TestParam getTaintParam() {
        return taintParam;
    }
}
