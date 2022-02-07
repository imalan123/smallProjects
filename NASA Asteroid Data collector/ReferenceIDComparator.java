/** ReferenceIDComparator implements comparator class for NEarEarthObjects so it can be used to sort
 * objects by reference id values
 *
 * Homework 7 CSE214
 *
 * @author Alan Jin
 *      email: alan.jin@stonybrook.edu
 *      Stony Brook ID: 112578370
 *      recitation # : R04
 */
public class ReferenceIDComparator implements java.util.Comparator<NearEarthObject> {

    public int compare(NearEarthObject left, NearEarthObject right) {
        if (left.getReferenceID() > right.getReferenceID()){
            return 1;
        } else if (left.getReferenceID() == right.getReferenceID()){
            return 0;
        } else {
            return -1;
        }
    }
}
