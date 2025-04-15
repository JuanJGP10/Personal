package ejercicios;

import java.util.ArrayList;
import java.util.List;

class SumDigPower {

    /*
     * The number
     * 89
     * 89 is the first integer with more than one digit that fulfills the property
     * partially introduced in the title of this kata. What's the use of saying
     * "Eureka"? Because this sum gives the same number:
     * 89
     * =
     * 8
     * 1
     * +
     * 9
     * 2
     * 89=8
     * 1
     * +9
     * 2
     * 
     * 
     * The next number in having this property is
     * 135
     * 135:
     * 
     * See this property again:
     * 135
     * =
     * 1
     * 1
     * +
     * 3
     * 2
     * +
     * 5
     * 3
     * 135=1
     * 1
     * +3
     * 2
     * +5
     * 3
     * 
     * 
     * Task
     * We need a function to collect these numbers, that may receive two integers
     * a
     * a,
     * b
     * b that defines the range
     * [
     * a
     * ,
     * b
     * ]
     * [a,b] (inclusive) and outputs a list of the sorted numbers in the range that
     * fulfills the property described above.
     * 
     * Examples
     * Let's see some cases (input -> output):
     * 
     * 1, 10 --> [1, 2, 3, 4, 5, 6, 7, 8, 9]
     * 1, 100 --> [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]
     * If there are no numbers of this kind in the range
     * [
     * a
     * ,
     * b
     * ]
     * [a,b] the function should output an empty list.
     * 
     * 90, 100 --> []
     * Enjoy it!!
     */
    public static List<Long> sumDigPow(long a, long b) {
        List<Long> retList = new ArrayList<>();
        for (long i = a; i < b; i++) {
            if (isProperty(i))
                retList.add(i);
        }

        return retList;

    }

    public static boolean isProperty(long number) {
        String numberStr = String.valueOf(number);
        long sum = 0;
        for (int i = 0; i < numberStr.length(); i++) {
            sum += Math.pow(Long.parseLong(numberStr.charAt(i) + ""), i + 1);
        }

        return (sum == number);
    }

    public static void main(String[] args) {
        List<Long> ex = sumDigPow(1, 100);
        for (Long long1 : ex) {
            System.out.print(long1 + " ");
        }
    }
}