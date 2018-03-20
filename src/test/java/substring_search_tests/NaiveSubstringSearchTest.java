package substring_search_tests;

import org.junit.Test;
import static org.junit.Assert.*;

import strings.substring_search.RabinKarp;
import strings.substring_search.ZAlgorithm;

public class NaiveSubstringSearchTest {
    ZAlgorithm Z=new ZAlgorithm();

    @Test
    public void emptryTextTest(){
        //boolean answer = NaiveSubstringSearch.containPatter("", "pattern");
        boolean answer = RabinKarp.containPattern("", "pattern");



        assertFalse(answer);
    }

    @Test
    public void emptyPatternTest(){
        //boolean answer = RabinKarp.containPattern("text", "");
        boolean answer =Z.Is_SubString("text","");
        assertFalse(answer);
    }

    @Test
    public void shouldReturnTrue(){
       // boolean answer = RabinKarp.containPattern("text to search", " to ");
        boolean answer =Z.Is_SubString("textpattern","pattern");
        assertTrue(answer);
    }

    @Test
    public void shouldReturnFalse(){
        //boolean answer = RabinKarp.containPattern("text to search", "to seac");
        boolean answer =Z.Is_SubString("textpattern","patrn");
        assertFalse(answer);
    }

}
