package src.main.java;

public class NumberUtil {

    // Check if number is prime
    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Check if number is palindrome
    public boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }

        int original = num;
        int reverse = 0;

        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }

        return original == reverse;
    }

    // Factorial (with exception)
    public int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Negative number not allowed");
        }

        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
