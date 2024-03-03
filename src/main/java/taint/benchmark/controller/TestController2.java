package taint.benchmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import taint.benchmark.domain.*;
import taint.benchmark.model.TestParam;
import taint.benchmark.service.*;
import taint.benchmark.sinks.SinkMethod;

@RequestMapping("test2")
@Controller
public class TestController2 {

    @Autowired
    private TestService1 testService1;

    @Autowired
    private TestService2 testService2;

    @Autowired
    private TestService3 testService3;

    @Autowired
    @Qualifier("testService4Impl1")
    private TestService4 testService4Impl1;

    @Autowired
    @Qualifier("testService4Impl2")
    private TestService4 testService4Impl2;

    @Autowired
    @Qualifier("testService4Impl3")
    private TestService4 testService4Impl3;

    @Autowired
    @Qualifier("testService4Impl4")
    private TestService4 testService4Impl4;

    @Autowired
    @Qualifier("testService5Impl1")
    private TestService5 testService5Impl1;

    @Autowired
    @Qualifier("testService5Impl2")
    private TestService5 testService5Impl2;

    @Autowired
    @Qualifier("testService5Impl3")
    private TestService5 testService5Impl3;

    @Autowired
    @Qualifier("testService5Impl4")
    private TestService5 testService5Impl4;

    @Autowired
    private TestBean1 testBean1;

    @Autowired
    private TestBean2 testBean2;

    @Autowired
    @Qualifier("testBean1")
    private TestBean testBean_1;

    @Autowired
    @Qualifier("testBean2")
    private TestBean testBean_2;

    @Autowired
    @Qualifier("testService6Impl1")
    private TestService6 testService6Impl1;

    @Autowired
    @Qualifier("testService6Impl2")
    private TestService6 testService6Impl2;

    @Autowired
    @Qualifier("testService6Impl2")
    private TestService6 testService6Impl2_c;


    @RequestMapping("/test5")
    public void test5(@RequestParam TestParam param) {
        testService1.sinkCall(param); // flow_droid tai_e
        testService2.sinkCall(param); // flow_droid tai_e
        testService3.sinkCall(param); // flow_droid tai_e
    }

    @RequestMapping("/test6")
    public void test6(@RequestParam TestParam param) {
        testService4Impl1.sinkCall(param); // flow_droid tai_e
        testService4Impl2.sinkCall(param);
        testService4Impl3.sinkCall(param);
        testService4Impl4.sinkCall(param); // flow_droid tai_e
    }

    @RequestMapping("/test7")
    public void test7(@RequestParam TestParam param) {
        testBean1.setTaintParam(param);
        testBean2.setTaintParam(param);
        SinkMethod.sink_7(testBean1.getTaintParam()); // flow_droid tai_e
        SinkMethod.sink_7(testBean2.getTaintParam()); // flow_droid tai_e

        testService5Impl1.sinkCall1(); // tai_e
        testService5Impl1.sinkCall2();
        testService5Impl2.sinkCall1(); // tai_e
        testService5Impl2.sinkCall2();
    }

    @RequestMapping("/test8")
    public void test8(@RequestParam TestParam param) {
        testBean_1.setTaintParam(param);
        testBean_2.setTaintParam(param);
        SinkMethod.sink_8(testBean_1.getTaintParam()); // flow_droid tai_e
        SinkMethod.sink_8(testBean_2.getTaintParam()); // flow_droid tai_e

        testService5Impl3.sinkCall1(); // tai_e
        testService5Impl3.sinkCall2(); // tai_e
        testService5Impl4.sinkCall1(); // tai_e
        testService5Impl4.sinkCall2(); // tai_e
    }

    @RequestMapping("/test9")
    public void test9(@RequestParam TestParam param) {
        testService6Impl2.setTaintParam(param);

        testService6Impl2_c.sinkCall1(); // tai_e
        testService6Impl2_c.sinkCall2(); // tai_e
        testService6Impl1.sinkCall1(); // tai_e
        testService6Impl1.sinkCall2();
    }
}
