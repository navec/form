package fr.arolla;

import fr.arolla.core.MyJunitRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by lenovo_9 on 11/04/2018.
 */
public class MyRuleTest {

    @Rule
    public final MyJunitRule personalRule = new MyJunitRule();

    @Test
    public void foo(){
        System.out.println("foo test rule");
    }
}
