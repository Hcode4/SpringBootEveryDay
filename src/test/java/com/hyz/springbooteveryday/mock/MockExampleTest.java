package com.hyz.springbooteveryday.mock;

import com.hyz.springbooteveryday.service.FinalClass;
import com.hyz.springbooteveryday.service.MyBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author HYZ
 * @Created 2021/8/21
 */
@Slf4j
@RunWith(PowerMockRunner.class)
@PrepareForTest(FinalClass.class)
@PowerMockIgnore("javax.management")
public class MockExampleTest {

    @Mock
    private FinalClass finalClass;

    @InjectMocks
    private MyBean myBean = new MyBean();

    @Test
    public void testFinalClass() {

        final String value = "What's up?";

        PowerMockito.when(finalClass.sayHello()).thenReturn(value);

        myBean.sayHello();
        finalClass.sayHello();

        log.info(myBean.sayHello());
        log.info(finalClass.sayHello());

        Assert.assertEquals(value, myBean.sayHello());
    }
}
