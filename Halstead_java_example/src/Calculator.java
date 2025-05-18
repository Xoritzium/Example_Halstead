public class Calculator {

    // adds to positive numbers
    public int add(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        return a+b;
    }

    // substract to positive numbers
    public int sub(int c, int d) {
        if (c < 0 || d < 0) {
            return -1;
        }
        return c-d;
    }

    // devide one/two if they are positive
    public int divide(int one, int two) {
        if (two == 0) {
            return -1;
        }
        return one/two;
    }

    // sum two positive integers
    public int sum(int first, int second) {
        return first*second;
    }
}