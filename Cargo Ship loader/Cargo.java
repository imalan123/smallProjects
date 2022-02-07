/** The Cargo object implements CargoStrength objects to get managed in CargoShip, ShipLoader, and CargoStack
 *
 * 
 *
 * @author Alan Jin
 *     
 */

public class Cargo {
    private String name;
    private double weight;
    private CargoStrength strength;

    /**Default constructor
     *
     * Preconditions
     *      <code>intitName</code> is not null
     *      <code>initWeight</code> is greater than zero
     *
     * Postconditions
     *      Object has been initialized to given <code>name</code>, <code>weight</code>,
     *          and <code>strength</code>
     * @param initName
     *      non-null string name for cargo item
     * @param initWeight
     *      weight of cargo that is larger than zero
     * @param initStrength
     *       <code>initStrength</code> is either FRAGILE, MODERATE, or STURDY
     * @throws IllegalArgumentException
     *      throws if <code>initName</code> is null or <code>initWeight</code> is less than 0
     */
    public Cargo(String initName, double initWeight,CargoStrength initStrength) throws IllegalArgumentException{
        if( initName == null){
            throw new IllegalArgumentException();
        } else if (initWeight <= 0 ){
            throw new IllegalArgumentException();
        } else {
            this.name = initName;
            this.weight = initWeight;
            this.strength = initStrength;
        }
    }

    /**Getter function for <code>name</code>
     *
     * @return
     *     The name of cargo
     */
    public String getName(){
        return this.name;
    }

    /**Getter function for <code>weight</code>
     *
     * @return
     *     the weight of cargo
     */
    public double getWeight(){
        return this.weight;
    }

    /**Getter function for <code>strength</code>
     *
     * @return
     *      strength of cargo
     */
    public CargoStrength getStrength(){
        return this.strength;
    }

}
