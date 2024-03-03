package taint.benchmark.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import taint.benchmark.model.TestParam;
import taint.benchmark.sinks.SinkMethod;

@RequestMapping("test")
@Controller
public class TestController5 {

    @Value("${test.enableSink}")
    private boolean enable;

    @Value("${test.disableSink}")
    private boolean disable;

    @RequestMapping("/test14")
    public void test14(@RequestParam TestParam param) {
        if (enable) {
            SinkMethod.sink_14(param); // flow_droid tai_e
        }

        if (!disable) {
            SinkMethod.sink_14(param);
        }
    }

}
