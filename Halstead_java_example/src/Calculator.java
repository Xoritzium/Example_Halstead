
public class Calculator {

<<<<<<< Updated upstream
    // yeeeaaa im a comment
=======
    //adds to positive numbers
    //faulty inputs should return -1
>>>>>>> Stashed changes
    public int add(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }

        if (a + b >= Integer.MAX_VALUE || a + b < 0) {
            return -1;
        }
        return a + b;
    }

<<<<<<< Updated upstream
=======
    // substract to positive numbers
    //faulty inputs should return -1
>>>>>>> Stashed changes
    public int sub(int c, int d) {
        if (c < 0 || d < 0) {
            return -1;
        }
        return c - d;
    }

<<<<<<< Updated upstream
=======
    // devide one/two if they are positive
    //faulty inputs should return -1
>>>>>>> Stashed changes
    public int divide(int one, int two) {
        if (two == 0) {
            return -1;
        }
        return one / two;
    }
<<<<<<< Updated upstream

    public int sum(int first, int second) {
        if(first == Integer.MAX_VALUE || second == Integer.MAX_VALUE){
            return -1;
        }
        if (first * second >= Integer.MAX_VALUE) {
            return -1;
        }
        return first * second;
=======
    // sum two positive integers 
    //faulty inputs should return -1
    public int sum(int first, int second){
        return 0;
>>>>>>> Stashed changes
    }
}