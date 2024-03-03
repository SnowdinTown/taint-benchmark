package taint.benchmark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import taint.benchmark.model.TestParam;
import taint.benchmark.sinks.SinkMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("test1")
@Controller
public class TestController1 {

    @RequestMapping("/test1")
    public void test1(@RequestParam TestParam param) {
        SinkMethod.sink_1(param); // flow_droid tai_e
        SinkMethod.sink_1(param.getId()); // flow_droid
        List<TestParam> params = new ArrayList<>();
        params.add(param);
        SinkMethod.sink_1(params); // flow_droid
        SinkMethod.sink_1(params.get(0)); // flow_droid
        params.add(new TestParam());
        SinkMethod.sink_1(params.get(1)); // flow_droid
    }

    @RequestMapping("/test2")
    public void test2(@RequestParam List<TestParam> params) {
        SinkMethod.sink_2(params); // flow_droid tai_e
        SinkMethod.sink_2(params.get(0)); // flow_droid
        SinkMethod.sink_2(params.get(0).getId());
    }

    @RequestMapping("/test3")
    public void test3(@RequestParam String s) {
        SinkMethod.sink_3(s); // flow_droid tai_e
        TestParam param = new TestParam();
        param.setId(s);
        SinkMethod.sink_3(param); // flow_droid
        SinkMethod.sink_3(param.getId()); // flow_droid tai_e
    }

    @RequestMapping("/test4")
    public void test4(HttpServletRequest request) {
        SinkMethod.sink_4(request); // flow_droid tai_e
        String parameter = request.getParameter("test");
        SinkMethod.sink_4(parameter); // tai_e
    }

}
