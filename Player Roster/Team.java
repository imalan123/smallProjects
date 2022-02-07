/** The <code>Team</code> that implements <code>Player</code> with a MAX player per team of 40 players
 *
 * Homework 1 CSE214
 *
 * @author Alan Jin
 *      email: alan.jin@stonybrook.edu
 *      Stony Brook ID: 112578370
 *      recitation # : R04
 *
 */
class Team extends TeamManager{
    public static final int MAX_PLAYERS = 40;
    private Player[] Teams;

    /**Default constructor that initializes Player array of Team object
     *
     * Postcondition:
     *      Team object is initialized to empty array of Players
     */
    public Team() {
        this.Teams = new Player[MAX_PLAYERS];
    }

    /**Generates a clone of this Team
     *
     * @return
     *    <code>copyTeams</code> creates a new memory address when cloning
     *          the selected Team object
     */
    public Object clone() {
        Team copyTeams = new Team();
        for(int player = 0; player < this.size() ;player++) {
            if (this.Teams[player] != null) {
                Player p = new Player(this.Teams[player].getName(),this.Teams[player].getNumberOfErrors(),
                        this.Teams[player].getNumberOfHits());
                try{
                    copyTeams.addPlayer(p, player+1);
                }catch(IllegalArgumentException check) {
                    System.out.println("Invalid range");
                } catch(FullTeamException check2){
                    System.out.println("Full team. Can not add more");
                }

            }
        }
        return copyTeams;
    }

    /**Compares this <code>Team</code> to another object for equality
     *
     * @param obj
     *      <code>obj</code> is compared to this <code>Team</code> object
     * @return
     *      returns true if they <code>Player</code> objects are
     *      the same in terms of name, hits, errors, and position order.
     */
    public boolean equals (Object obj) {
        boolean isEqual = false;
        int equalCount =0;
        if (obj instanceof Team) {
            for (int count = 0; count <= this.size(); count++) {
                if (this.Teams[count] == null || ((Team) obj).Teams[count] == null) {
                    continue;
                } else {
                    if (this.Teams[count].getName().equals(((Team) obj).Teams[count].getName()) &&
                            this.Teams[count].getNumberOfErrors() == (((Team) obj).Teams[count].getNumberOfErrors()) &&
                            this.Teams[count].getNumberOfHits() == (((Team) obj).Teams[count].getNumberOfHits())) {
                        equalCount++;
                    }
                }
            }
            if (equalCount == this.size()&& this.size() == ((Team) obj).size()){
                isEqual = true;
            }
            return isEqual;
        } else {
            return false;
        }
    }

    /**Determines the number of Players currently in this Team
     *
     * Precondition
     *      This team has been created
     *
     * @return <code>count</code>
     *      the number of Players in this Team
     *
     */
    public int size() {
        int count = 0;
        for (int walker = 0; walker < MAX_PLAYERS; walker++) {
            if (this.Teams[walker] != null) {
                count++;
            }
        }
        return count;
    }

    /**Adds a <code>Player</code> to this <code>Team</code>
     *
     * @param p
     *      The new <code>Player</code> object to add to this <code>Team</code>
     * @param position
     *      The position in the lineup where the Player will be inserted
     * Preconditions
     *      <code>Team</code> object has been created
     *      1 greater than or equal to <code>position</code> and less than or equal to this <code>Team</code> size + 1
     * Postconditions
     *      new Player is now stored at <code>position</code> and previous
     *          <code>Player</code> objects are shifted back one position
     *      E.g. If <code>position</code> was 1 and the <code>Team</code>
     *           object had 5 <code>Player</code> objects already, the old position
     *           1 player will become 2, and the old 2 position player will become 3
     *           and etc.
     * @throws IllegalArgumentException
     *      Indicates the position isn't in valid range
     * @throws FullTeamException
     *       Indicates this <code>Team</code> is full, and no new <code>Player</code> objects can be added
     */
    public void addPlayer(Player p, int position) throws IllegalArgumentException, FullTeamException{
        if (this.size() >= MAX_PLAYERS) {
            throw new FullTeamException();
        } else if (position < 1 || position > this.size() + 1){
            throw new IllegalArgumentException("Invalid range");
        } else if (this.size() == 0){
            this.Teams[0] = p;
        } else {
            for (int placement = position-1; placement <= this.size(); placement++) {
                Player walker = this.Teams[placement];
                this.Teams[placement] = p;
                p = walker;
            }
        }
    }

    /**Removes a <code>Player</code> from the team at <code>position</code> value in the lineup
     *
     * @param position
     *      the position in the lineup from which the <code>Player</code> is to be removed
     * Preconditions
     *     This team is created
     *     1 greater than or equal to <code>position</code> and less than or equal to this <code>Team</code> size + 1
     * Postconditions
     *      <code>Player</code> object at desired position in the team has been removed
     *      <code>Player</code> objects right of removed object will be shifted left one position
     *      E.g. In a team of 5 players with player 3 removed, Player 4 will take over player 3's position
     *          and Player 5 will take over player 4's position
     * @throws IllegalArgumentException
     *      Indicates the position is not in valid range
     */
    public void removePlayer(int position)throws IllegalArgumentException {
        if (position == MAX_PLAYERS) {
            this.Teams[position-1] = new Player();
        } else if(position <1 || position > this.size() + 1){
            throw new IllegalArgumentException("Invalid range");
        }else {
            for (int i = position-1 ; i < this.size(); i++) {
                this.Teams[i] = this.Teams[i+1];
            }
        }

    }

    /**Returns a reference to a player in the lineup at the indicated position
     *
     * @param position
     *      the position in the lineup which the <code>Player</code> is retrieved
     * Preconditions
     *      Team has been created already
     * @return this.Teams[position-1];
     *      the player of the given index
     * @throws IllegalArgumentException
     *      indicates position is not within valid range
     */

    public Player getPlayer(int position) throws IllegalArgumentException{
        if (position >=1 && position <= this.size()) {
            return this.Teams[position-1];
        } else {
            throw new IllegalArgumentException("Invalid Range");
        }


    }

    /**Return the player with the best value in the given statistic(hits/errors)
     *
     * @param stat
     *      determines whether user is trying to find leader in hits or errors
     * @return leader
     *      The Player with the best stat
     * @throws IllegalArgumentException
     *      Indicates that indicated state was neither hits/errors
     */
    public Player getLeader(int stat) throws IllegalArgumentException {
        int maxHit = this.Teams[0].getNumberOfHits();
        int minError = this.Teams[0].getNumberOfErrors();
        Player leader = this.Teams[0];
        switch(stat) {
            case 0 :
                for (int i = 1; i < this.size(); i++) {
                    if (this.Teams[i].getNumberOfErrors() < minError) {
                        minError = this.Teams[i].getNumberOfErrors();
                        leader = this.Teams[i];
                    }
                }
                break;
            case 1 :
                for (int i = 1; i < this.size(); i++) {
                    if (this.Teams[i].getNumberOfHits() > maxHit) {
                        maxHit = this.Teams[i].getNumberOfHits();
                        leader = this.Teams[i];
                    }
                }
                break;
            default: throw new IllegalArgumentException("input not 1 or 0");
        }
        return leader;
    }

    /**Prints a neat table of each <code>Player</code> object and their position, name, and stats
     *
     * Preconditions
     *     Team has been created already
     * Postconditions
     *     Neat table of each <code>Player</code> in the <code>Team</code> on its own line
     *          along with their position number
     */
    public void printAllPlayers() {
        System.out.printf("%5s %27s %10s %10s", "Player #", "Name", "Hits", "Errors");
        System.out.println();
        for (int k = 0; k < this.size(); k++) {
            System.out.format("%5d %30s %10d %10d\n",
                    k + 1, this.Teams[k].getName(), this.Teams[k].getNumberOfHits(), this.Teams[k].getNumberOfErrors());
        }

    }

    /**Updates a player's stats according to parameter values
     *
     * Preconditions
     *      Player object is already created
     *
     * Postconditions
     *      the Player object's hits/errors is changed to new values indicated by parameters
     *
     * @param n
     *      the name of player to search for
     * @param stat
     *      to see if they are changing errors or hits
     * @param newValue
     *      the new value of hits/errors that's being changed to
     * @throws IllegalArgumentException
     *      indicates invalid option has been selected
     */
    public void updatePlayer(String n, int stat, int newValue) throws IllegalArgumentException{
        if (this.size() == 0) {
            throw new IllegalArgumentException("Empty Team");
        } else{
            for (int i = 0; i < this.size(); i++){
                if (this.Teams[i].getName().equals(n)){
                    switch (stat){
                        case 0:
                            this.Teams[i].setNumberOfErrors(newValue);
                            break;
                        case 1:
                            this.Teams[i].setNumberOfHits(newValue);
                            break;
                        default: throw new IllegalArgumentException("Invalid Option");
                    }
                }
            }
        }
    }

    /**Gets String representation of this <code>Team</code> object, with each Player and their positon
     *  on one line each player.
     *
     * @return result + result2
     *      The <code>String</code> representation of this <code>Team</code> object
     */
    public String toString() {
        String result = String.format("%5s %27s %10s %10s\n", "Player #", "Name", "Hits", "Errors");
        String result2 = "";
        for (int k = 0; k < this.size(); k++) {
            result2 += String.format("%5d %30s %10d %10d\n",
                    k + 1, this.Teams[k].getName(), this.Teams[k].getNumberOfHits(), this.Teams[k].getNumberOfErrors());
        }

        return result + result2;
    }

}
