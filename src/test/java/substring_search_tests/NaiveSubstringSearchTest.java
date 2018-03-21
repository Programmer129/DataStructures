package substring_search_tests;

import org.junit.Test;
import static org.junit.Assert.*;
import strings.substring_search.NaiveSubstringSearch;
import strings.substring_search.RabinKarp;

import java.util.Random;

public class NaiveSubstringSearchTest {

    @Test
    public void emptryTextTest(){
        boolean answer = NaiveSubstringSearch.containPattern("", "pattern");

        assertFalse(answer);
    }

    @Test
    public void emptyPatternTest(){
        boolean answer = NaiveSubstringSearch.containPattern("text", "");

        assertFalse(answer);
    }

    @Test
    public void shouldReturnTrue(){
        boolean answer = NaiveSubstringSearch.containPattern("text to search", " to ");

        assertTrue(answer);
    }

    @Test
    public void shouldReturnFalse(){
        boolean answer = NaiveSubstringSearch.containPattern("text to search", "to seac");

        assertFalse(answer);
    }

}
