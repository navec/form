package fr.arolla.junit;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyUselessRule implements TestRule {

  public Statement apply(Statement base, Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        System.out.println("test in progress ");
        System.out.println(description);
        base.evaluate();
      }
    };
  }
}