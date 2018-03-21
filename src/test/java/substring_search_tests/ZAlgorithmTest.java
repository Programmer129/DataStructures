package substring_search_tests;

import org.junit.Test;
import strings.substring_search.ZAlgorithm;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ZAlgorithmTest {

    @Test
    public void emptryTextTest(){
        boolean answer = ZAlgorithm.containPattern ("", "pattern");

        assertFalse(answer);
    }
    @Test
    public void emptyPatternTest(){
        boolean answer =ZAlgorithm.containPattern("text","");

        assertFalse(answer);
    }
    @Test
    public void shouldReturnTrue(){
        boolean answer =ZAlgorithm.containPattern("text pattern","pattern");

        assertTrue(answer);
    }
    @Test
    public void shouldReturnFalse(){
        boolean answer =ZAlgorithm.containPattern("text pattern","patrn");

        assertFalse(answer);
    }
}
