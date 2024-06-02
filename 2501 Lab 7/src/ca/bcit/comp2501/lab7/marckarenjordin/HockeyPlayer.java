package ca.bcit.comp2501.lab7.marckarenjordin;

/**
 * A hockey player in a team and a league.
 *
 * @author Marc André Baron-Campeau
 * @author Karen Lim
 * @author Jordin Pirooz
 *
 * @version 1.0
 */
public class HockeyPlayer
{
            final int        id;
    private final String     name;
    private final int        heightCm;
    private       int        weightKg;
    private final String     birthDate;
    private final String     shootingHand;
    private final String     position;
    private       HockeyTeam currentTeam;
    private       int        lastYearScore;

    private static final int    PLAYER_NAME_MAX_LENGTH = 50;
    private static final double PLAYER_MIN_HEIGHT      = 0.0;
    private static final double PLAYER_MIN_WEIGHT      = 0.0;
    private static final int    PLAYER_MIN_SCORE       = 0;
    private static       int    PLAYER_ID_COUNTER      = 1;

    /**
     * Creates a player for a hockey league.
     *
     * @param name          the name of the player
     * @param heightCm      the height of the player in cm
     * @param weightKg      the weight of the player in kg
     * @param birthDate     the birthdate of the player
     * @param shootingHand  the shooting hand of the player
     * @param position      the position of the player
     * @param currentTeam   the current team of the player
     * @param lastYearScore the last year score of the player
     *
     * @throws IllegalArgumentException when parameters are of the wrong format
     */
    public HockeyPlayer(final String     name,
                        final int        heightCm,
                        final int        weightKg,
                        final String     birthDate,
                        final String     shootingHand,
                        final String     position,
                        final HockeyTeam currentTeam,
                        final int        lastYearScore)
    throws IllegalArgumentException
    {
        if(name.length() > PLAYER_NAME_MAX_LENGTH)
        {
            throw new IllegalArgumentException("Name is too long.");
        }
        if(heightCm < PLAYER_MIN_HEIGHT)
        {
            throw new IllegalArgumentException("Height must be a positive number greater than " + PLAYER_MIN_HEIGHT + " cm.");

        }
        if(weightKg < PLAYER_MIN_WEIGHT)
        {
            throw new IllegalArgumentException("Weight must be a positive number greater than " + PLAYER_MIN_WEIGHT + " kg.");
        }
        if(shootingHand != null &&
          !shootingHand.isBlank() &&
         (!shootingHand.equalsIgnoreCase("left") &&
          !shootingHand.equalsIgnoreCase("Right")))
        {
            throw new IllegalArgumentException("Must be either Right or Left.");
        }
        if(position != null &&
          !position.isBlank() &&
         (!position.equalsIgnoreCase("Goalie") &&
          !position.equalsIgnoreCase("Right Winger") &&
          !position.equalsIgnoreCase("Left Winger") &&
          !position.equalsIgnoreCase("Center") &&
          !position.equalsIgnoreCase("Right Defense") &&
          !position.equalsIgnoreCase("Left Defense")))
        {
            throw new IllegalArgumentException("Position must be one of the 6 positions: Goalie, Right Winger, Left Winger, Center, Right Defense, and Left Defense.");
        }
        if(currentTeam == null)
        {
            throw new IllegalArgumentException("Must use an existing team.");
        }
        if(lastYearScore < PLAYER_MIN_SCORE)
        {
            throw new IllegalArgumentException("Last year score must be greater or equal to " + PLAYER_MIN_SCORE + ".");
        }

        this.id            = PLAYER_ID_COUNTER;
        this.name          = name;
        this.heightCm      = heightCm;
        this.weightKg      = weightKg;
        this.birthDate     = birthDate;
        this.shootingHand  = shootingHand;
        this.position      = position;
        this.currentTeam   = currentTeam;
        this.lastYearScore = lastYearScore;

        PLAYER_ID_COUNTER++;
    }

    /**
     * Resets the player ID counter.
     */
    public static void resetIdCounter()
    {
        PLAYER_ID_COUNTER = 1;
    }

    /**
     * Displays the information of the player.
     *
     * @return the information of the player
     */
    public String displayInfo()
    {
        return "Player ID: "       + id + "\n"
             + "Name: "            + name + "\n"
             + "Height: "          + heightCm + " cm\n"
             + "Weight: "          + weightKg + " kg\n"
             + "Birth Date: "      + birthDate + "\n"
             + "Shooting Hand: "   + shootingHand + "\n"
             + "Position: "        + position + "\n"
             + "Current Team: "    + currentTeam.getTeamName() + "\n"
             + "Last Year Score: " + lastYearScore + "\n";
    }

    /**
     * Retires the player by removing the team.
     */
    public void retirePlayer()
    {
        //currentTeam.removePlayer(this);
        this.currentTeam = null;
    }

    /**
     * Gets the current team of the player.
     *
     * @return the current team of the player
     */
    public HockeyTeam getCurrentTeam()
    {
        return currentTeam;
    }

    /**
     * Sets the team of the player.
     *
     * @param team the team to set
     */
    public void setCurrentTeam(final HockeyTeam team)
    {
        this.currentTeam = team;
    }
}
