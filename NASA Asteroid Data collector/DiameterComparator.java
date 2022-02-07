/** DiameterComparator implements comparator class for NEarEarthObjects so it can be used to sort
 * objects by average diameter values
 *
 * Homework 7 CSE214
 *
 * @author Alan Jin
 *      email: alan.jin@stonybrook.edu
 *      Stony Brook ID: 112578370
 *      recitation # : R04
 */

public class DiameterComparator implements java.util.Comparator<NearEarthObject> {
    public int compare(NearEarthObject left, NearEarthObject right) {
        if (left.getAverageDiameter() > right.getAverageDiameter()) {
            return 1;
        } else if (left.getAverageDiameter() == right.getAverageDiameter()) {
            return 0;
        } else {
            return -1;
        }
    }
}
