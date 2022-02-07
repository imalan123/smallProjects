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
public class ShipOverweightException extends IllegalArgumentException {
    public ShipOverweightException(){
        super("Ship is overweight");
    }
}
