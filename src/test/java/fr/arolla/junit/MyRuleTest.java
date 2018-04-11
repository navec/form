package fr.arolla.junit;

import org.junit.Rule;
import org.junit.Test;

/**
 *
 */
public class MyRuleTest {

    @Rule
    public MyUselessRule rule = new MyUselessRule();

    @Test
    public void should_rule(){
        System.out.println("mon test");
    }
}
