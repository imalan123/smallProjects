/** The ShipLoader object implements CargoShip, CargoStack, Cargo, and CargoStrength objects for the user to use
 *
 * Homework 3 CSE214
 *
 * @author Alan Jin
 *      email: alan.jin@stonybrook.edu
 *      Stony Brook ID: 112578370
 *      recitation # : R04
 */

import java.util.Scanner;
import java.util.Stack;
public class ShipLoader {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        Stack<Cargo> dock = new Stack<Cargo>();
        System.out.println("Welcome to ShipLoader!");
        System.out.println("Cargo Ship Parameters:");
        System.out.println("-------------------------------------");
        System.out.println("Number of stacks: ");
        int numStack = in.nextInt();
        System.out.println("Maximum height of stacks: ");
        int maxHeight = in.nextInt();
        System.out.println("Maximum total cargo weight: ");
        double maxWeight = in.nextDouble();

        CargoShip ship = new CargoShip(numStack, maxHeight, maxWeight);


        while(true){
            try {
                System.out.println("Please select an option: ");
                System.out.println("C) Create new cargo");
                System.out.println("L) Load cargo from dock");
                System.out.println("U) Unload cargo from ship");
                System.out.println("M) Move cargo between stacks");
                System.out.println("K) Clear dock");
                System.out.println("P) Print ship stacks");
                System.out.println("S) Search for cargo");
                System.out.println("Q) Quit");

                char ans = in.next().charAt(0);

                switch (Character.toLowerCase(ans)) {
                    case 'c':
                        Cargo item;
                        in.nextLine();
                        System.out.println("Name: ");
                        String name = in.nextLine();

                        System.out.println("Weight: ");
                        double weight = in.nextDouble();

                        System.out.println("Enter container strength (F/M/S)");
                        char strength = in.next().charAt(0);

                        switch (Character.toLowerCase(strength)) {
                            case 'f':
                                item = new Cargo(name, weight, CargoStrength.FRAGILE);
                                dock.push(item);
                                break;
                            case 'm':
                                item = new Cargo(name, weight, CargoStrength.MODERATE);
                                if (dock.isEmpty()) {
                                    dock.push(item);
                                } else if (dock.peek().getStrength() == CargoStrength.FRAGILE) {
                                    System.out.println("Operation failed. Cargo at stack can not support weight");
                                } else {
                                    dock.push(item);
                                }
                                break;
                            case 's':
                                item = new Cargo(name, weight, CargoStrength.STURDY);
                                if (dock.isEmpty()) {
                                    dock.push(item);
                                } else if (dock.peek().getStrength() == CargoStrength.FRAGILE || dock.peek().getStrength() == CargoStrength.MODERATE) {
                                    System.out.println("Operation failed. Cargo at stack can not support weight");
                                } else {
                                    dock.push(item);
                                }
                                break;
                            default:
                                System.out.println("invalid input");
                                break;
                        }
                        break;
                    case 'l':
                        System.out.println("Select the load destination stack index: ");
                        int index = in.nextInt();
                        try {
                            ship.pushCargo(dock.pop(), index - 1);
                        } catch (FullStackException e){
                            System.out.println("Full stack");
                        } catch (ShipOverweightException e2){
                            System.out.println("Ship overweight");
                        } catch (CargoStrengthException e3){
                            System.out.println("Can not place on weaker strength cargo");
                        }

                        break;
                    case 'u':
                        System.out.println("Select the unload source stack index: ");
                        index = in.nextInt();
                        try {
                            dock.push(ship.popCargo(index - 1));
                        } catch (FullStackException e){
                            System.out.println("Full stack");
                        } catch (ShipOverweightException e2){
                            System.out.println("Ship overweight");
                        } catch (CargoStrengthException e3){
                            System.out.println("Can not place on weaker strength cargo");
                        }
                        System.out.println("Cargo moved from index " + index + " to dock");
                        break;
                    case 'm':
                        int index1, index2;
                        System.out.println("Source stack index: ");
                        index1 = in.nextInt();
                        System.out.println("Destination stack index:");
                        index2 = in.nextInt();
                        try {
                            ship.pushCargo(ship.popCargo(index1 - 1), index2 - 1);
                        } catch (FullStackException e){
                            System.out.println("Full stack");
                        } catch (ShipOverweightException e2){
                            System.out.println("Ship overweight");
                        } catch (CargoStrengthException e3){
                            System.out.println("Can not place on weaker strength cargo");
                        }


                        break;
                    case 'k':
                        int dockSize = dock.size();
                        for (int i = 0; i < dockSize; i++) {
                            dock.pop();
                        }
                        System.out.println("Dock Cleared");
                        break;
                    case 'p':
                        Stack<Cargo> reverse = new Stack<Cargo>();
                        ship.printAll();
                        int sizeOfDock = dock.size();
                        System.out.println("Dock: ");
                        for (int i = 0; i < sizeOfDock; i++) {
                            Cargo temp = dock.pop();
                            switch (temp.getStrength()){
                                case FRAGILE:
                                    System.out.println("F");break;
                                case MODERATE:
                                    System.out.println("M");break;
                                case STURDY:
                                    System.out.println("S");break;
                            }
                            reverse.push(temp);
                        }
                        for (int j = 0; j < sizeOfDock; j++) {
                            dock.push(reverse.pop());
                        }
                        break;
                    case 's':
                        in.nextLine();
                        System.out.println("Enter name of cargo: ");
                        name = in.nextLine();
                        ship.findAndPrint(name);
                        break;
                    case 'q':
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } catch (IllegalArgumentException e){
                System.out.println(" Illegal argument Exception: invalid bounds");
            }
        }
    }
}
