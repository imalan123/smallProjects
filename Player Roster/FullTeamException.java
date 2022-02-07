/**The <code>FullTeamException</code> that indicates if full team condition is met
 *
 * Homework 1 CSE214
 *
 * @author Alan Jin
 *      email: alan.jin@stonybrook.edu
 *      Stony Brook ID: 112578370
 *      recitation # : R04
 *
 *
 */
public class FullTeamException extends Exception{
    public FullTeamException() {
        super("Team is full");
    }
}