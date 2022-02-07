/** The <code>Player</code> that is being implemented in <code>Team</code> and <code>TeamManager</code>
 *
 * Homework 1 CSE214
 *
 * @author Alan Jin
 *      email: alan.jin@stonybrook.edu
 *      Stony Brook ID: 112578370
 *      recitation # : R04
 */
class Player extends Team{
    private String name;

    private int numberOfHits;

    private int numberOfErrors;

    /**Default constructor that initializes Player objects to default values
     * Postcondition:
     *       Team object is initialized to initial values
     */
    public Player() {
        this.name = "";
        this.numberOfErrors = 0;
        this.numberOfHits = 0;
    }

    /**Constructer that initiates its values to its input variables
     *
     * Postcondition:
     *      Team object is initialized to parameter values
     * @param n
     *      The name of the Player object initializes to
     * @param e
     *      The number of errors Player object initializes to
     * @param h
     *      The number of hits Player object initializes to
     */
    public Player(String n, int e, int h) {
        this.name = n;
        this.numberOfErrors = e;
        this.numberOfHits = h;
    }

    /**Gets the private value name variable
     *
     * Preconditions
     *      Player has been instantiated
     *
     * @return name
     *      name of this player
     */
    public String getName() {
        return name;
    }

    /**Changes the name to parameter input
     *
     * Preconditions
     *      Player has been instantiated
     *
     * Postconditions
     *      Player object's name is changed to input parameter
     *
     * @param name
     *      the new name the Player object will take on
     */
    public void setName(String name) {
        this.name = name;
    }

    /**retrieves the number of hits this Player object has
     *
     *  Preconditions
     *      Player has been instantiated
     *
     * @return numberOfHits
     *      the number of hits the player has on record
     */
    public int getNumberOfHits() {
        return numberOfHits;
    }

    /**Changes the number of hits value of the Player object to the input parameter
     *
     * Preconditions
     *      Player has been instantiated
     *
     * Postconditions
     *      Player object's numberOfHits is changed to input parameter
     *
     *
     * @param numberOfHits
     *      the new number of hits value that <code>numberOfHits</code> will change to
     * @throws IllegalArgumentException
     *      indicates that new hits value can not be under 0
     */
    public void setNumberOfHits(int numberOfHits) throws IllegalArgumentException {
        if (numberOfHits >= 0) {
            this.numberOfHits = numberOfHits;
        } else {
            throw new IllegalArgumentException("Hits can not be negative.");
        }

    }

    /**Retrieves the number of errors <code>Payer</code> object has
     *
     * Preconditions
     *      Player has been instantiated
     *
     * @return numberOfErrors
     *      the number of errors this <code>Player</code> object has
     */
    public int getNumberOfErrors() {
        return numberOfErrors;
    }

    /**Changes the <code>numberOfErrors</code> of this <code>Player</code> object
     *
     * Preconditions
     *      Player has been instantiated
     *
     * Postconditions
     *      <code>Player</code> object's <code>numberOfErrors</code> changed to input parameter
     *
     *
     * @param numberOfErrors
     *      the new value the <code>numberOfErrors</code> adopts
     * @throws IllegalArgumentException
     *      indicates that the new value for <code>numberOfErrors</code> can not be less than 0
     */
    public void setNumberOfErrors(int numberOfErrors) throws IllegalArgumentException {
        if (numberOfErrors >= 0) {
            this.numberOfErrors = numberOfErrors;
        } else {
            throw new IllegalArgumentException("Errors can not be negative.");
        }
    }

    /**Returns the name, hits, and errors of player
     *
     * Preconditions
     *      Player has been instantiated
     *
     *
     * @return
     *      string of player information including name, hits, and errors
     */
    public String toString() {
        return "Name: " + this.name + "\tHits:" + this.numberOfHits + "\t\tErrors:" + this.numberOfErrors;
    }

}