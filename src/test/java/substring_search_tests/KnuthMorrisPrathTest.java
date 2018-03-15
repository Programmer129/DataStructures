package substring_search_tests;

import org.junit.Test;
import strings.substring_search.KnuthMorrisPrath;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KnuthMorrisPrathTest {

    @Test
    public void emptryTextTest(){
        boolean answer = KnuthMorrisPrath.containPattern("", "pattern");

        assertFalse(answer);
    }

    @Test
    public void emptyPatternTest(){
        boolean answer = KnuthMorrisPrath.containPattern("text", "");

        assertFalse(answer);
    }

    @Test
    public void shouldReturnTrue(){
        boolean answer = KnuthMorrisPrath.containPattern("text to search", " to ");

        assertTrue(answer);
    }

    @Test
    public void shouldReturnFalse(){
        boolean answer = KnuthMorrisPrath.containPattern("text to search", "to seac");

        assertFalse(answer);
    }
}
