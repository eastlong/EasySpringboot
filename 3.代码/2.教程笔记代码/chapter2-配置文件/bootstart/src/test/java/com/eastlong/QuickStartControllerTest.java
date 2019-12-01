package com.eastlong;

import com.eastlong.controller.QuickStartController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class QuickStartControllerTest {
    @Autowired
    private QuickStartController controller;

    @Test
    public void testQuick(){
        System.out.println("test result:" + controller.quick());
    }
}
