/** IllegalArgumentException
 *
 * Homework 3 CSE214
 *
 * @author Alan Jin
 *      email: alan.jin@stonybrook.edu
 *      Stony Brook ID: 112578370
 *      recitation # : R04
 */

/**Extension of Illegal Argument Exception
 *
 */

public class FullStackException extends IllegalArgumentException{
    public FullStackException(){
        super("Stack is full");
    }
}
