import java.util.Scanner;

/** The <code>TeamManager</code> implements <code>Team</code> and <code>Player</code> in a series of
 *      input commands.
 *
 * Homework 1 CSE214
 *
 * @author Alan Jin
 *      email: alan.jin@stonybrook.edu
 *      Stony Brook ID: 112578370
 *      recitation # : R04
 */
public class TeamManager implements Cloneable {
    public static final int MAX_TEAMS =5;

    public static void main(String [] args){

        Scanner in =  new Scanner(System.in);

        Team[] manageTeam = new Team[MAX_TEAMS];

        initializeArray(manageTeam);
        char input= '.';
        Player p1 = new Player();

        String n;
        int h,e,playerPosition, teamPosition=0, ans;

        while (!(input == 'Q')|| !(input == 'q')){
            int selectedTeam = teamPosition+1;
            System.out.println("Team " + selectedTeam + " is currently selected");
            System.out.println("Please select an option: ");
            System.out.println ("A) Add Player");
            System.out.println ("G) Get Player stats");
            System.out.println ("L) Get Leader in a stat");
            System.out.println ("R) Remove a player");
            System.out.println ("P) Print all Players");
            System.out.println ("S) Size of team");
            System.out.println ("T) Select Team");
            System.out.println ("C) Clone team");
            System.out.println ("E) Team equals");
            System.out.println ("U) Update stat");
            System.out.println ("Q) Quit");
            input = in.next().charAt(0);
            //
            //
            switch (Character.toLowerCase(input)){
                case 'a':
                    n = in.nextLine();
                    System.out.println("Name: ");
                    n = in.nextLine();

                    System.out.println("Hits: ");
                    h = in.nextInt();

                    System.out.println("Errors: ");
                    e = in.nextInt();

                    System.out.println("Position: ");
                    playerPosition = in.nextInt();

                    Player p = new Player(n,e,h);
                    try{
                        manageTeam[teamPosition].addPlayer(p, playerPosition);
                    } catch(IllegalArgumentException check) {
                        System.out.println("Invalid range");
                    } catch(FullTeamException check2){
                        System.out.println("Full team. Can not add more");
                    }

                    System.out.println("Player added: \n" + p.toString());
                    break;
                case 'g':
                    System.out.println("Position: ");
                    ans= in.nextInt();
                    try {
                        p1 = manageTeam[teamPosition].getPlayer(ans);
                        System.out.println(p1.toString());
                    }
                    catch (IllegalArgumentException check){
                        System.out.println("Invalid range");
                    }

                    break;
                case 'l':
                    System.out.println("0. Errors");
                    System.out.println("1. Hits");
                    ans = in.nextInt();
                    try {
                        System.out.println("Leader: " + manageTeam[teamPosition].getLeader(ans).toString());
                    }
                    catch (IllegalArgumentException check){
                        System.out.println("input not 1 or 0");
                    }
                    break;

                case 'r':
                    System.out.println("Position: ");
                    ans = in.nextInt();
                    try{
                        manageTeam[teamPosition].removePlayer(ans);
                    } catch(IllegalArgumentException check){
                        System.out.println("Invalid range");
                    }
                    break;

                case 'p':
                    System.out.println("Team index: ");
                    ans = in.nextInt();
                    manageTeam[ans-1].printAllPlayers();
                    break;

                case 's':
                    System.out.println("Size:" + manageTeam[teamPosition].size());
                    break;
                case 't':
                    System.out.println("Select team 1-5");
                    ans = in.nextInt();
                    if (ans>=1 && ans <=5){
                        teamPosition = ans-1;
                        System.out.println("Team " + ans + " selected");
                    }
                    else{
                        System.out.println("Number is not between or equal to 1 and 5");
                    }

                    break;
                case 'c':
                    System.out.println("Clone Team index: ");
                    ans = in.nextInt();
                    System.out.println("Clone to which Team index: ");
                    e = in.nextInt();
                    if (e < 1 || e > 5) {
                        System.out.println("Please enter between 1 to 5 since there is only 5 teams.");
                    } else if (ans == e) {
                        System.out.println("Why you cloning the same team?");
                    } else {
                        Team newTeam = (Team) manageTeam[ans-1].clone();
                        manageTeam[e-1] = newTeam;
                    }
                    System.out.println("Cloned team index " + ans);
                    break;
                case 'e':
                    System.out.println("First Team index: ");
                    ans = in.nextInt();
                    System.out.println("Second Team index: ");
                    e = in.nextInt();
                    if (manageTeam[ans - 1].equals(manageTeam[e - 1])){
                        System.out.println("Teams are equal");
                    } else{
                        System.out.println("Teams are not equal");
                    }
                    break;
                case 'u':
                    n = in.nextLine();
                    System.out.println("Player Name: ");
                    n = in.nextLine();

                    System.out.println("Errors(0) or Hits(1)");
                    e = in.nextInt();

                    System.out.println("New value: ");
                    ans = in.nextInt();
                    try {
                        manageTeam[teamPosition].updatePlayer(n,e,ans);
                    }
                    catch(IllegalArgumentException check){
                        System.out.println("Empty team or input for Error or Hits question is not 1 or 0");
                    }


                    break;

                case 'q': System.exit(0);
                    break;
                default: System.out.println("Invalid choice");
            }

        }


    }

    /**Initializes the empty Team object array with empty Team objects
     *
     * Preconditions
     *      Team array has already been created
     *
     * @param mt
     *      Team object array parameter array to initialize
     */
    public static void initializeArray(Team[] mt){
        for (int i = 0; i<MAX_TEAMS;i++){
            Team t = new Team();
            mt[i] = t;
        }
    }
}

