package taint.benchmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import taint.benchmark.model.TestParam;
import taint.benchmark.service.TestService8;
import taint.benchmark.sinks.SinkMethod;

@RequestMapping("test")
@Controller
public class TestController6 {

    @Autowired
    TestService8 testService8;

    @RequestMapping("/test17")
    public void saveParam(TestParam param) {
        testService8.saveParam(param); // flow_droid
    }

    @RequestMapping("/test16")
    public TestParam getParam(Integer i) {
        TestParam param = testService8.getParam(i);
        SinkMethod.sink_16(param); // flow_droid
        return param;
    }
}
