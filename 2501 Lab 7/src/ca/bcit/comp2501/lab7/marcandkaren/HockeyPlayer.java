package ca.bcit.comp2501.lab7.marcandkaren;

/**
 * A hockey player in a team and a league.
 *
 * @author Marc André Baron-Campeau
 * @author Karen Lim
 *
 * @version 1.0
 */
public class HockeyPlayer
{
    private final  int    id;
    private final  String name;
    private final  int    height;
    private        int    weight;
    private final  String birthDate;
    private final  String shootingHand;
    private final  String position;
    private        String currentTeam;
    private        int    lastYearScore;

    private static int    ID_COUNTER = 1;

    /**
     * Creates a player for a hockey league.
     *
     * @param name          the name of the player
     * @param height        the height of the player
     * @param weight        the weight of the player
     * @param birthDate     the birthdate of the player
     * @param shootingHand  the shooting hand of the player
     * @param position      the position of the player
     * @param currentTeam   the current team of the player
     * @param lastYearScore the last year score of the player
     */
    public HockeyPlayer(final String name,
                        final int    height,
                        final int    weight,
                        final String birthDate,
                        final String shootingHand,
                        final String position,
                        final String currentTeam,
                        final int    lastYearScore)
    {
        this.id            = ID_COUNTER++;
        this.name          = name;
        this.height        = height;
        this.weight        = weight;
        this.birthDate     = birthDate;
        this.shootingHand  = shootingHand;
        this.position      = position;
        this.currentTeam   = currentTeam;
        this.lastYearScore = lastYearScore;
    }

    /**
     * Resets the player ID_COUNTER.
     */
    public static void resetIdCounter()
    {
        ID_COUNTER = 1;
    }

    /**
     * Displays the information of the player
     *
     * @return the information of the player
     */
    public String displayInfo()
    {
        return "Player ID: "       + id + "\n"
             + "Name: "            + name + "\n"
             + "Height: "          + height + " cm\n"
             + "Weight: "          + weight + " kg\n"
             + "Birth Date: "      + birthDate + "\n"
             + "Shooting Hand: "   + shootingHand + "\n"
             + "Position: "        + position + "\n"
             + "Current Team: "    + currentTeam + "\n"
             + "Last Year Score: " + lastYearScore + "\n";
    }

    /**
     * Retires the player.
     */
    public void retirePlayer()
    {
        this.currentTeam = null;
    }

    /**
     * Gets the current team of the player.
     *
     * @return the current team of the player
     */
    public String getCurrentTeam()
    {
        return currentTeam;
    }

    /**
     * Sets the current team of the player.
     * @param currentTeam the current team to set
     */
    public void setCurrentTeam(final String currentTeam)
    {
        this.currentTeam = currentTeam;
    }
}
