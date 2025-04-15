package ejercicios;

public class PersistentBugger {
    /*
     * Write a function, persistence, that takes in a positive parameter num and
     * returns its multiplicative persistence, which is the number of times you must
     * multiply the digits in num until you reach a single digit.
     * 
     * For example (Input --> Output):
     * 
     * 39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit, there
     * are 3 multiplications)
     * 999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2,
     * there are 4 multiplications)
     * 4 --> 0 (because 4 is already a one-digit number, there is no multiplication)
     */
    public static int persistence(long n) {
        StringBuilder number = new StringBuilder(String.valueOf(n));
        int solution = 0;
        int newNumber;
        while (number.length() > 1) {
            newNumber = 1;
            for (int i = 0; i < number.length(); i++) {
                newNumber *= Character.getNumericValue(number.charAt(i));
            }
            number.delete(0, number.length());
            number.append(newNumber);
            solution += 1;
        }

        return solution;
    }

    public static void main(String[] args) {
        System.out.println(persistence(39));
    }
}