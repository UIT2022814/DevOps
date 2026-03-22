package src.test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.main.java.Add;

public class AddTest {
    
    @Test
    void testForAddNum() {
        Add obj = new Add();
        Assertions.assertEquals(5, obj.addNum(2,3));
    }
}
