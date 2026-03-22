package src.test.java;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import src.main.java.NumberUtil;

public class NumberUtilTest {

    NumberUtil obj;
    
    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Before All Tests");
    }

    @BeforeEach
    void setUp() {
        obj = new NumberUtil();
        System.out.println("SetUp: Object Created");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TearDown: Test Completed");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("After All Tests");
    }

    // Check for prime numbers
    @Test
    void testForIsPrimePositive() {
        assertTrue(obj.isPrime(5));
    }

    @Test
    void testForIsPrimeNegative() {
        assertFalse(obj.isPrime(-78));
    }

    @Test
    void testForIsPrimeZeroAndOne() {
        assertFalse(obj.isPrime(1));
        assertFalse(obj.isPrime(0));
    }

    //Check for palindrome numbbers
    @Test
    void testForIsPalindrome() {
        assertTrue(obj.isPalindrome(121));
    }

    @Test
    void testForIsNotPalindrome() {
        assertFalse(obj.isPalindrome(234));
    }

    @Test
    void testForIsPalindromeNegative() {
        assertFalse(obj.isPalindrome(-121));
    }


    //Test for factorial
    @Test
    void testforFactorial() {
        assertEquals(120, obj.factorial(5));
    }

    @Test
    void testForNegativeFactorial() {
        assertThrows(IllegalArgumentException.class, () -> {
                obj.factorial(-2);
        });
    }

    @Test
    @DisabledOnOs(value=OS.WINDOWS, disabledReason="Disabled on windows OS")
    void testForZeroFactorial() {
        assertNotEquals(0, obj.factorial(1));
    }

    @RepeatedTest(3)
    void repeatedTests() {
        assertTrue(1 == obj.factorial(0));
    }

    //Multiple Assertions
    @Test
    void testMultipleAssertions() {
        assertAll(
            () -> assertTrue(obj.isPrime(11)),
            () -> assertTrue(obj.isPalindrome(222)),
            () -> assertEquals(24, obj.factorial(4)),
            () -> assertNotNull(obj)
        );
    }

    //Parameterized Test
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 12, 6, 8})
    void testForPrimeNumbers(int num) {
        assertFalse(obj.isPrime(num));
    }

    // @ParameterizedTest
    // @CsvSource({
    //     "0, 1",
    //     "1, 1",
    //     "3, 6",
    //     "4, 24",
    //     "5, 120"
    // })
    // void testFactorialParameterized(int input, int expected) {
    //     Assertions.assertEquals(expected, obj.factorial(input));
    // }   

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6"
    })
    void testFactorialParameterized(int input, int expected) {
        assertEquals(expected, obj.factorial(input));
    }
}
