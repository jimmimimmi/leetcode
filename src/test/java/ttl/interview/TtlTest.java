package ttl.interview;

import com.ttl.interview.Ttl;
import junit.framework.TestCase;

import java.util.List;

public class TtlTest extends TestCase {
    public void testName() {
        var result1 = new Ttl().findWord(List.of("W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"));

        //        var result2 = new Ttl().getLargestPiece("100,70", List.of(80, 20), List.of(35));
//        var result3 = new Ttl().getLargestPiece("100,70", List.of(80, 20), List.of(35));
//        var result4 = new Ttl().getLargestPiece("100,70", List.of(80, 20), List.of(35));
//        var result5 = new Ttl().getLargestPiece("100,70", List.of(80, 20), List.of(35));
//        var result6 = new Ttl().getLargestPiece("100,70", List.of(80, 20), List.of(35));
//        var result7 = new Ttl().getLargestPiece("100,70", List.of(80, 20), List.of(35));
//        assertEquals(60 * 35, result1.intValue());

        System.out.println(result1);
    }
}