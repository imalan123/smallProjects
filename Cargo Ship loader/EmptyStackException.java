/** IllegalArgumentException
 *
 *
 * @author Alan Jin
 */

/**Extension of Illegal Argument Exception
 *
 */
public class EmptyStackException extends IllegalArgumentException {
    public EmptyStackException(){
        super("Stack is empty");
    }
}
