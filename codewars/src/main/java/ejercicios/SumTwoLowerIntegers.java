package ejercicios;

import java.util.Arrays;

public class SumTwoLowerIntegers {
    /*
     * ^
     * Create a function that returns the sum of the two lowest positive numbers
     * given an array of minimum 4 positive integers. No floats or non-positive
     * integers will be passed.
     * 
     * For Java, those integers will come as double precision (long).
     * 
     * For example, when an array is passed like [19, 5, 42, 2, 77], the output
     * should be 7.
     * 
     * [10, 343445353, 3453445, 3453545353453] should return 3453455.
     */
    public static long sumTwoSmallestNumbers(long[] numbers) {

        return Arrays.stream(numbers).sorted().limit(2).sum();
    }

    public static void main(String[] args) {
        long[] num = { 19, 5, 42, 2, 77 };
        System.out.println(sumTwoSmallestNumbers(num));
    }
}
