package taint.benchmark.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import taint.benchmark.model.TestParam;

/**
 * @Description UserMapper
 */
@Mapper
@Repository
public interface TestMapper{

    int insert(TestParam model);

    TestParam select(Integer id);

}
