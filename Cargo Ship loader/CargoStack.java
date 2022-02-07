/** The CargoStack object implements Cargo and CargoStrength objects to manage them in stacks
 *
 *
 * @author Alan Jin
 */


import java.util.Stack;
public class CargoStack {
    private Stack<Cargo> cargoStack;
    private double currentWeight =0;
    private int size = 0;

    /**Default constructor of CargoStack
     *
     * postcondition:
     *      initializes CargoStack object
     *
     */
    CargoStack() {
        this.cargoStack = new Stack<Cargo>();
        this.currentWeight = 0;
    }

    /**Returns the current weight of all cargo on ship
     *
     * @return
     *      returns current weight of cargo on ship
     */
    public double getCurrentWeight(){
        return currentWeight;
    }

    /**pushes values into cargo stack
     *
     * Preconditions:
     *      Cargo is not null
     *
     * Postconditions;
     *      Cargo is successfully pushed into stack
     *
     * @param cargo
     *      The cargo is pushed into stack
     */
    public void push(Cargo cargo){
        size++;
        cargoStack.push(cargo);
        currentWeight += cargo.getWeight();
    }

    /**Pops object out of cargo stack
     *
     * Preconditions:
     *      Stack is not null
     * Postconditions:
     *      cargo is successfully popped and returned
     *
     * @return
     *      returns popped object
     */
    public Cargo pop(){
        Cargo temp = cargoStack.pop();
        currentWeight -= temp.getWeight();
        size--;
       return temp;

    }

    /**peeks the top value of stack
     *
     * @return
     *      The cargo at the top of cargo
     */
    public Cargo peek(){
        return cargoStack.peek();
    }

    /**returns the size of cargo
     *
     * @return
     *      returns current size of cargo stack
     */
    public int size() {
        return size;
    }

    /**Checks if cargo stack is empty
     *
     * @return
     *      returns true if it is empty or false if it is not
     */
    public boolean empty(){
        return cargoStack.empty();
    }


}
