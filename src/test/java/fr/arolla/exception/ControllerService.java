package fr.arolla.exception;

import java.util.Random;

/**
 *
 */
public class ControllerService {


    private Random random = new Random();

    public void doSomething(){

        for (int i = 0; i < 10; i++) {
            doOtherThing(i);
        }

    }

    private void doOtherThing(int i) {
        try{
            doStuff(i);
            doBidule(i);
            doingThis(i);
        } catch (Exception e){
            throw new IllegalStateException("error");
        }
    }

    private void doingThis(int i) {
        System.out.println(i);
    }



    private void doBidule(int i) {
        if(i%2==0){
            System.out.println(i*2);
        }

        save();
    }




































    private void save() {
        if(random.nextBoolean() && new Random().nextBoolean()){
            throw new IllegalArgumentException("random error occur here");
        }
    }

    private void doStuff(int i) {
        if(i==5){
            System.out.println(i);
        }
    }
}
