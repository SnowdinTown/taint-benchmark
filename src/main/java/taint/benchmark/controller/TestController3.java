package taint.benchmark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import taint.benchmark.model.TestParam;
import taint.benchmark.service.TestService1;
import taint.benchmark.service.TestService2;
import taint.benchmark.service.TestService3;

@RequestMapping("test3")
@Controller
public class TestController3 {

    private TestService1 testService1;
    private TestService2 testService2;
    private TestService3 testService3;

    public TestController3(TestService1 service1, TestService2 service2, TestService3 service3) {
        testService1 = service1;
        testService2 = service2;
        testService3 = service3;
    }

    @RequestMapping("/test5")
    public void test5(@RequestParam TestParam param) {
        testService1.sinkCall(param); // flow_droid tai_e
        testService2.sinkCall(param); // flow_droid tai_e
        testService3.sinkCall(param); // flow_droid tai_e
    }

}
