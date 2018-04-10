package fr.arolla.maybe;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 */
public class Maybe<TYPE> {

    private TYPE value;

    private Maybe(TYPE nullaleValue) {
        this.value=nullaleValue;
    }

    public static <TYPE> Maybe<TYPE> from(TYPE nullaleValue){
        return new Maybe<TYPE>(nullaleValue);
    }

    public boolean isPresent(){
        return value!=null;
    }

    public TYPE get(){
        return value;
    }

    public boolean is(Predicate<TYPE> predicate){
        return predicate.test(value);
    }

    public <OUT_TYPE> Maybe<OUT_TYPE> to(Function<TYPE, OUT_TYPE> function){
        return new Maybe<OUT_TYPE>(function.apply(value));
    }

    public <IN_TYPE,OUT_TYPE> OUT_TYPE convert(IN_TYPE value,Function<IN_TYPE, OUT_TYPE> function){
        return function.apply(value);
    }




}
