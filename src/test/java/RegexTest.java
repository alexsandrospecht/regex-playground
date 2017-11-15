import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegexTest {
    private StringMatcher m;

    @Before
    public void setup(){
        m = new StringMatcher();
    }

    @Test
    public void isTrue() {
        assertTrue(m.isTrue("true"));
        assertFalse(m.isTrue("true2"));
        assertFalse(m.isTrue("True"));
    }

    @Test
    public void isTrueCap() {
        assertTrue(m.isTrueCap("true"));
        assertFalse(m.isTrueCap("true2"));
        assertTrue(m.isTrueCap("True"));
    }

    @Test
    public void isTrueOrYes() {
        assertTrue(m.isTrueOrYes("true"));
        assertTrue(m.isTrueOrYes("yes"));
        assertTrue(m.isTrueOrYes("Yes"));
        assertFalse(m.isTrueOrYes("no"));
    }

    @Test
    public void containsTrue() {
        assertTrue(m.containsTrue("thetruewithin"));
    }

    @Test
    public void isThreeLetters() {
        assertTrue(m.isThreeLetters("abc"));
        assertFalse(m.isThreeLetters("abcd"));
    }

    @Test
    public void isNoNumberAtBeginning() {
        assertTrue(m.isNoNumberAtBeginning("abc"));
        assertFalse(m.isNoNumberAtBeginning("1abcd"));
        assertTrue(m.isNoNumberAtBeginning("a1bcd"));
        assertTrue(m.isNoNumberAtBeginning("asdfdsf"));
    }

    @Test
    public void isIntersection() {
        assertTrue(m.isIntersection("1"));
        assertFalse(m.isIntersection("abcksdfkdskfsdfdsf"));
        assertTrue(m.isIntersection("skdskfjsmcnxmvjwque484242"));
    }

    @Test
    public void lessThenThreeHundred() {
        assertTrue(m.isLessThenThreeHundred("288"));
        assertFalse(m.isLessThenThreeHundred("3288"));
        assertFalse(m.isLessThenThreeHundred("328 8"));
        assertTrue(m.isLessThenThreeHundred("1"));
        assertTrue(m.isLessThenThreeHundred("99"));
        assertFalse(m.isLessThenThreeHundred("300"));
    }
}
