package ca.bcit.comp2501.lab7.marckarenjordin;

import java.util.ArrayList;

/**
 * A hockey team in a league.
 *
 * @author Marc André Baron-Campeau
 * @author Karen Lim
 * @author Jordin Pirooz
 *
 * @version 1.0
 */
public class HockeyTeam
{
            final int          id;
    private final String       teamName;
    private final String       teamCity;
    private final int          teamFoundationYear;
    private       HockeyLeague currentLeague;
    private final ArrayList<HockeyPlayer> players;

    private static final int TEAM_NAME_MAX_LENGTH     = 50;
    private static final int TEAM_CITY_MAX_LENGTH     = 50;
    private static final int TEAM_MIN_FOUNDATION_YEAR = 1875;
    private static       int TEAM_ID_COUNTER          = 1;

    /**
     * Creates a team for a hockey league.
     *
     * @param teamName           the name of the team
     * @param teamCity           the city of the team
     * @param teamFoundationYear the year the team was founded
     * @param currentLeague      the league name the team belongs to
     *
     * @throws IllegalArgumentException when parameters are of the wrong format
     */
    public HockeyTeam(final String       teamName,
                      final String       teamCity,
                      final int          teamFoundationYear,
                      final HockeyLeague currentLeague)
    throws IllegalArgumentException
    {
        if(teamName.length() > TEAM_NAME_MAX_LENGTH)
        {
            throw new IllegalArgumentException("Name is too long.");
        }
        if(teamCity.length() > TEAM_CITY_MAX_LENGTH)
        {
            throw new IllegalArgumentException("Name is too long.");
        }
        if(teamFoundationYear < TEAM_MIN_FOUNDATION_YEAR)
        {
            throw new IllegalArgumentException("Team foundation year must be greater or equal to " + TEAM_MIN_FOUNDATION_YEAR + ".");
        }
        if(currentLeague == null)
        {
            throw new IllegalArgumentException("Must use an existing league.");
        }
        this.id                 = TEAM_ID_COUNTER;
        this.teamName           = teamName;
        this.teamCity           = teamCity;
        this.teamFoundationYear = teamFoundationYear;
        this.currentLeague      = currentLeague;
        this.players            = new ArrayList<>();

        TEAM_ID_COUNTER++;
    }

    /**
     * Resets the team ID counter.
     */
    public static void resetIdCounter()
    {
        TEAM_ID_COUNTER = 1;
    }

    /**
     * Adds a player to the team.
     *
     * @param player the player to add
     */
    public void addPlayer(final HockeyPlayer player)
    {
        if(!players.contains(player))
        {
            players.add(player);
            player.setCurrentTeam(this);
        }
    }

    /**
     * Adds a player to the team.
     *
     * @param player the player to add
     */
    public void removePlayer(final HockeyPlayer player)
    {
        if(players.contains(player))
        {
            player.retirePlayer();
            players.remove(player);
        }
    }

    /**
     * Displays information about all players in the team.
     *
     * @return the information about all players
     */
    public String displayPlayersInfo()
    {
        final StringBuilder info = new StringBuilder();
        for (final HockeyPlayer player : players)
        {
            info.append(player.displayInfo()).append("\n");
        }
        return info.toString();
    }

    /**
     * Gets the name of the team.
     *
     * @return the team name
     */
    public String getTeamName()
    {
        return teamName;
    }

    /**
     * Remove the team from the league.
     */
    public void leaveLeague()
    {
        this.currentLeague = null;
    }

    /**
     * Gets the current league.
     *
     * @return the current league
     */
    public HockeyLeague getCurrentLeague()
    {
        return currentLeague;
    }

    /**
     * Sets the current league of the team.
     *
     * @param league the current league to set
     */
    public void setCurrentLeague(final HockeyLeague league)
    {
        this.currentLeague = league;
    }

    /**
     * Gets the list of players in the team.
     * @return the list of players
     */
    public ArrayList<HockeyPlayer> getPlayersList()
    {
        return players;
    }

    /**
     * Move a player from this team to another team.
     *
     * @param player    the player
     * @param otherTeam the other team
     *
     * @throws IllegalArgumentException when the other team does not exist or when the player is not part of the team
     */
    public void transferPlayer(final HockeyPlayer player,
                               final HockeyTeam   otherTeam)
    throws IllegalArgumentException
    {
        if(otherTeam == null)
        {
            throw new IllegalArgumentException("Must use an existing team.");
        }
        if(!getPlayersList().contains(player))
        {
            throw new IllegalArgumentException("Player must be part of this team.");
        }

        this.players.remove(player);
        otherTeam.addPlayer(player);
    }
}
