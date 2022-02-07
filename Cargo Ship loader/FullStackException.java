/** IllegalArgumentException
 *
 *
 * @author Alan Jin
 */

/**Extension of Illegal Argument Exception
 *
 */

public class FullStackException extends IllegalArgumentException{
    public FullStackException(){
        super("Stack is full");
    }
}
