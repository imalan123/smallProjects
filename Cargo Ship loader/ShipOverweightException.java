/** IllegalArgumentException
 *
 *
 * @author Alan Jin
 */

/**Extension of Illegal Argument Exception
 *
 */
public class ShipOverweightException extends IllegalArgumentException {
    public ShipOverweightException(){
        super("Ship is overweight");
    }
}
