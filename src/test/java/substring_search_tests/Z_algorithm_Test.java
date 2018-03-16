package substring_search_tests;

import org.junit.Test;
import static org.junit.Assert.*;
import strings.substring_search.Z_Algorithm;

public class Z_algorithm_Test {
    Z_Algorithm Z  = new Z_Algorithm();
    @Test
    public void emptryTextTest(){
        boolean answer =Z.Is_SubString ("", "pattern");

        assertFalse(answer);
    }
    @Test
    public void emptyPatternTest(){
        boolean answer =Z.Is_SubString("text","");
        assertFalse(answer);
    }
    @Test
    public void shouldReturnTrue(){

        boolean answer =Z.Is_SubString("textpattern","pattern");
        assertTrue(answer);
    }
    @Test
    public void shouldReturnFalse(){
        boolean answer =Z.Is_SubString("textpattern","patrn");
        assertFalse(answer);
    }

}
