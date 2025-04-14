package ejercicios;

import java.util.Arrays;
import java.util.List;

public class HighAndLow {
    /*
     * In this little assignment you are given a string of space separated numbers,
     * and have to return the highest and lowest number.
     * 
     * Examples
     * highAndLow("1 2 3 4 5") // return "5 1"
     * highAndLow("1 2 -3 4 5") // return "5 -3"
     * highAndLow("1 9 3 4 -5") // return "9 -5"
     * Notes
     * All numbers are valid Int32, no need to validate them.
     * There will always be at least one number in the input string.
     * Output string must be two numbers separated by a single space, and highest
     * number is first.
     */
    public static String highAndLow(String numbers) {
        String res = "";
        List<Integer> list = Arrays.stream(numbers.split(" ")).map(Integer::parseInt).toList();
        res += (int) list.stream().max((s1, s2) -> s1 - s2).orElse(0) + " ";
        res += (int) list.stream().min((s1, s2) -> s1 - s2).orElse(0);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(highAndLow("1 2 3 4 5"));
    }
}
