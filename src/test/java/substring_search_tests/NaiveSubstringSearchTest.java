package substring_search_tests;

import org.junit.Test;
import static org.junit.Assert.*;
import strings.substring_search.NaiveSubstringSearch;

public class NaiveSubstringSearchTest {

    @Test
    public void emptryTextTest(){
        boolean answer = NaiveSubstringSearch.containPatter("", "pattern");

        assertFalse(answer);
    }

    @Test
    public void emptyPatternTest(){
        boolean answer = NaiveSubstringSearch.containPatter("text", "");

        assertFalse(answer);
    }

    @Test
    public void shouldReturnTrue(){
        boolean answer = NaiveSubstringSearch.containPatter("text to search", " to se");

        assertTrue(answer);
    }

    @Test
    public void shouldReturnFalse(){
        boolean answer = NaiveSubstringSearch.containPatter("text to search", "to seac");

        assertFalse(answer);
    }

}
