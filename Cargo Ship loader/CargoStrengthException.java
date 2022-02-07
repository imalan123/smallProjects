public class CargoStrengthException extends IllegalArgumentException {
    public CargoStrengthException(){
        super("Stronger cargo can not be stacked onto weaker cargo");
    }
}
