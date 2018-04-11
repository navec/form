package fr.arolla.generique;

/**
 * Created by lenovo_9 on 10/04/2018.
 */
public final class Maybe<E> {

    private final E element;

    private Maybe(E element) {
        this.element = element;
    }

    public final static <TYPE> Maybe<TYPE> from(TYPE element) {
        return new Maybe<TYPE>(element);
    }

    E get(){
        return element;
    }

    boolean isPresent(){
        return element != null;
    }
}
