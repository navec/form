package fr.arolla.core;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by lenovo_9 on 11/04/2018.
 */
public class MyJunitRule implements TestRule {
    @Override
    public Statement apply(final Statement statement, Description description) {
        return new Statement(){
            @Override
            public void evaluate() throws Throwable {
                System.out.println("My Junit Rule statement");
                System.out.println("My Junit Rule description");
                statement.evaluate();
            }
        };
    }
}
