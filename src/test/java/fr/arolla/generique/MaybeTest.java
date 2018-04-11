package fr.arolla.generique;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by lenovo_9 on 10/04/2018.
 */
public class MaybeTest {

    @Test
    public void getStringContent() throws Exception {
        // Given
        String contentExpected = "coucou";
        Maybe<String> maybe = Maybe.from(contentExpected);

        // When
        String element = maybe.get();

        // Then
        assertEquals(contentExpected, element);
    }

    @Test
    public void getIntContent() throws Exception {
        // Given
        Integer contentExpected = 32;
        Maybe<Integer> maybe = Maybe.from(contentExpected);

        // When
        Integer element = maybe.get();

        // Then
        assertEquals(contentExpected, element);
    }

    @Test
    public void isPresent() throws Exception {
        // Given
        Integer content = 32;
        Maybe<Integer> maybe = Maybe.from(content);
        boolean expexted = true;

        // When
        boolean isPresent = maybe.isPresent();

        // Then
        assertEquals(expexted, isPresent);
    }

}