package taint.benchmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import taint.benchmark.model.TestParam;
import taint.benchmark.service.TestService7;
import taint.benchmark.sinks.SinkMethod;

@RequestMapping("test4")
@Controller
public class TestController4 {

    @Autowired
    private TestService7 testService7;

    @RequestMapping("/test10")
    public void test10(@RequestParam TestParam testParam, int i) {
        SinkMethod.sink_10(testParam); // flow_droid tai_e
    }

    @RequestMapping("/test11")
    public TestParam test11(@RequestParam TestParam testParam) {
        SinkMethod.sink_11(testParam); // flow_droid tai_e
        return testParam;
    }

    @RequestMapping("/test12")
    public void test12(@RequestParam TestParam testParam, int i) {
        testService7.sinkCall(testParam, i); // flow_droid tai_e
    }

    @RequestMapping("/test13")
    public TestParam test13(@RequestParam TestParam testParam) {
        return testService7.sinkCall(testParam); // flow_droid tai_e
    }

    @RequestMapping("/test15")
    public TestParam test15(@RequestParam TestParam testParam) {
        SinkMethod.sink_15(testParam); // flow_droid tai_e
        return testParam;
    }
}
