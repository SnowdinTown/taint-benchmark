package taint.benchmark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taint.benchmark.mapper.TestMapper;
import taint.benchmark.model.TestParam;
import taint.benchmark.service.TestService8;

@Service
public class TestService8Impl implements TestService8 {

    @Autowired
    TestMapper mapper;

    @Override
    public void saveParam(TestParam param) {
        mapper.insert(param);
    }

    @Override
    public TestParam getParam(Integer i) {
        return mapper.select(i);
    }
}
