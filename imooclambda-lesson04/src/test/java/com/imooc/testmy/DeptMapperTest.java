package com.imooc.testmy;

import com.imooc.mapper.DeptMapper;
import com.imooc.pojo.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Copyright (C), 2018-2019, copyright info. DAMU., Ltd.
 * FileName: com.imooc.test DeptMapperTest
 * <p>TODO</p>
 *
 * @author <a href="http://blog.csdn.net/muwenbin_flex">大牧莫邪</a>
 * @version 1.00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptMapperTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void testFindAll() {
        List<Dept> deptList = deptMapper.findAll();
        System.out.println(deptList);
    }
}
