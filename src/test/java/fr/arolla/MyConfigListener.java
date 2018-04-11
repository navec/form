package fr.arolla;

import fr.arolla.core.MyConfig;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

/**
 * Created by lenovo_9 on 11/04/2018.
 */
public class MyConfigListener extends AbstractTestExecutionListener {

    public void beforeTestClass(TestContext testContext) throws Exception {
        MyConfig myConfigAnnotation = testContext.getTestClass().getAnnotation(MyConfig.class);
        System.out.println(myConfigAnnotation.getIntValue());
        System.out.println(myConfigAnnotation.getStringValue());
    }


}