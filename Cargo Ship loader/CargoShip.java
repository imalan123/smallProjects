/** The CargoShip object implements CargoStack, Cargo, and CargoStrength objects to allocate objects on/off the ship
 *
 *
 * @author Alan Jin
 */


import java.util.Stack;

public class CargoShip {
    private CargoStack[] stacks;
    private int numStacks;
    private int maxHeight;
    private double maxWeight;


    /**Default constructor
     *
     * Preconditions
     *      <code>numStacks</code>, <code>initMaxHeight</code>, and <code>initMaxWeight</code> is greater than 0
     *
     * Postconditions
     *     <code>CargoShip</code> is initialized to input parameters
     *
     * @param numStacks
     *      The number of stacks the ship can support
     * @param initMaxHeight
     *      The maximum height of any stack on the ship
     * @param initMaxWeight
     *      The maximum weight for all cargo on ship
     * @throws IllegalArgumentException
     *      if either of the parameters are not within the appropriate bounds
     */
    public CargoShip(int numStacks, int initMaxHeight, double initMaxWeight) throws IllegalArgumentException{
        if( numStacks <= 0 || initMaxHeight <=0 || initMaxWeight <= 0){
            throw new IllegalArgumentException();
        } else {
            this.stacks = new CargoStack[numStacks];
            for (int i = 0; i < numStacks; i++){
                stacks[i] =  new CargoStack();
            }
            this.numStacks = numStacks;
            this.maxHeight = initMaxHeight;
            this.maxWeight = initMaxWeight;
        }

    }


    /**Pushes a cargo container to the indicated stack on the cargo ship
     *
     *Preconditions:
     *      CargoShip is initialized and not null
     *      Cargo is initialized and not null
     *      stack is greater than or equal to 1 and less than or equal to stacks.length
     *      Size of stack at desired index is less than maxHeight
     *      Total weight of all Cargo on ship and cargo.getWeight is less than max weight
     *Postconditions:
     *      The cargo is successfully pushed back to given stack or appropriate
     *          exception is thrown while ship stays the same.
     *
     * @param cargo
     *      The container to place on the stack
     * @param stack
     *      The index of the stack on the ship to push cargo onto
     * @throws IllegalArgumentException
     *      Thrown if cargo is null or stack is not in appropriate bounds
     * @throws FullStackException
     *      Thrown if stack being pushed to is at max height
     * @throws ShipOverweightException
     *      Thrown if cargo would exceed maxWeight
     * @throws CargoStrengthException
     *      Thrown if cargo is stacked on top of a weaker cargo
     */
    public void pushCargo(Cargo cargo,int stack) throws FullStackException, ShipOverweightException, CargoStrengthException {
        if (cargo == null || (stack < 0 || stack >= this.numStacks)) {
            throw new IllegalArgumentException();
        } else if (this.stacks[stack].size() >= maxHeight) {
            throw new FullStackException();
        } else if (this.stacks[stack].getCurrentWeight() + cargo.getWeight() > maxWeight) {
            throw new ShipOverweightException();
        } else {
            switch (cargo.getStrength()){
                case FRAGILE:
                    stacks[stack].push(cargo);
                    break;
                case MODERATE:
                    if (stacks[stack].empty()){
                        stacks[stack].push(cargo);
                    } else if (stacks[stack].peek().getStrength() == CargoStrength.FRAGILE){
                        throw new CargoStrengthException();
                    } else {
                        stacks[stack].push(cargo);
                    }
                    break;
                case STURDY:
                    if (stacks[stack].empty()){
                        stacks[stack].push(cargo);
                    } else if (stacks[stack].peek().getStrength() == CargoStrength.FRAGILE || stacks[stack].peek().getStrength() == CargoStrength.MODERATE ){
                        throw new CargoStrengthException();
                    } else {
                        stacks[stack].push(cargo);
                    }
                    break;
                default:
                    System.out.println("Invalid strength");break;
            }

        }

    }

    /** Pops a cargo from one of the specified stack
     *
     * Preconditions:
     *      CargoShip is initialized and not null
     *
     * Postconditions:
     *      Cargo is successfully popped from the stack and returned or appropriate exception is thrown
     *
     * @param stack
     *      the index of the stack to remove from cargo from
     * @return
     *      returns the popped cargo
     * @throws EmptyStackException
     *      Thrown if stack is empty
     * @throws IllegalArgumentException
     *      Thrown if stack is not in appropriate bounds
     */
    public Cargo popCargo(int stack) throws EmptyStackException{
        if (stacks[stack].empty()){
            throw new EmptyStackException();
        } else if (stack < 0 || stack >= maxHeight){
            throw new IllegalArgumentException();
        } else {
            Cargo temp = stacks[stack].pop();
            return temp;
        }

    }

    /**Finds and prints a formatted table of all the cargo on the ship with given name
     *
     * preconditions:
     *      CargoShip is initialized and not null
     *
     * postconditions:
     *      The details found cargo with name are printed. CargoShip remains unchanged
     *
     * @param name
     *      name of the cargo to find and print
     */
    public void findAndPrint(String name){
        Stack<Cargo> tempStock = null;
        CargoStack reverseStack = null;
        double totalWeight = 0;
        System.out.printf("%8s %8s %8s %8s\n","Stack","Depth","Weight","Strength");
        for (int stackCount = 0; stackCount < this.stacks.length; stackCount++) {
            tempStock = new Stack<Cargo>();
            reverseStack = new CargoStack();
                int trackSize = this.stacks[stackCount].size();
                for (int j = 0; j < trackSize ; j++){
                    Cargo data = this.stacks[stackCount].pop();
                    tempStock.push(data);
                    if (data.getName().equals(name)){
                        switch (data.getStrength()){
                            case FRAGILE:
                                System.out.printf("%8d | %8d | %10.2f | %10s\n",stackCount,j,data.getWeight(),"FRAGILE");
                                break;
                            case MODERATE:
                                System.out.printf("%8d | %8d | %10.2f | %10s\n",stackCount,j,data.getWeight(),"MODERATE");
                                break;
                            case STURDY:
                                System.out.printf("%8d | %8d | %10.2f | %10s\n",stackCount,j,data.getWeight(),"STURDY");
                                break;

                        }
                    }
                }

            for (Cargo tempData : tempStock) {
                reverseStack.push(tempData);
            }
            this.stacks[stackCount] = reverseStack;
        }
    }

    /**Prints all the values of the cargo on each dock of the ship
     *
     */
    public void printAll(){
        Stack<Cargo> tempStock = null;
        double totalWeight = 0;
        for (int stackCount = 0; stackCount < numStacks; stackCount++) {
            int num =stackCount+1;
            System.out.println("--------------------------------------------");
            System.out.println("Dock " + num + ": ");
            tempStock = new Stack<Cargo>();

                int sizeTrack = this.stacks[stackCount].size();
                for (int j = 0; j < sizeTrack; j++){
                    Cargo data = this.stacks[stackCount].pop();
                    switch (data.getStrength()){
                        case FRAGILE:
                            System.out.println("F");break;
                        case MODERATE:
                            System.out.println("M");break;
                        case STURDY:
                            System.out.println("S");break;
                    }
                    tempStock.push(data);
                }

            for (Cargo tempData : tempStock) {
                this.stacks[stackCount].push(tempData);
            }

            totalWeight+= this.stacks[stackCount].getCurrentWeight();
        }
        System.out.println("--------------------------------------------");
        System.out.println("Total Weight " + totalWeight + "/" + maxWeight );
    }



}
