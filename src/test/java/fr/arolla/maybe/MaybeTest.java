package fr.arolla.maybe;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 *
 */
public class MaybeTest {

    @Test
    public void should_construct_maybe_from_string(){
        Maybe<String> value = Maybe.from("coucou");
        assertEquals(true, value.isPresent());
        assertEquals("coucou",value.get());
    }

    @Test
    public void should_construct_empty_maybe(){
        assertEquals(false, Maybe.from(null).isPresent());
    }

    @Test
    public void should_construct_maybe_from_integer(){
        Maybe<Integer> value = Maybe.from(34);
        assertEquals(true, value.isPresent());
        assertEquals(new Integer(34),value.get());
    }


}